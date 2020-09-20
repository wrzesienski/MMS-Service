package TerminalModel.URCB;

import IedStructure.*;
import MmsServices.UnconfirmedServices.EventNotification;
import TerminalModel.NodeConnector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ReportControl extends NodeConnector {
    private String sigUnderCon;
    private String nodeUnderCon;
    private boolean trip;
    private boolean order;
    private NodeConnector prisoner;

    public ReportControl(LogicalNode logicalNode, String underCon){
        super(logicalNode, new ArrayList<String>(Collections.singleton(underCon)));
        order = true;
    }

    public ReportControl(LogicalNode ln){
        this(ln, null);
        order = true;
    }

    public void setPrisoner(NodeConnector prisoner){
        this.prisoner = prisoner;
    }

    public NodeConnector getPrisoner(){
        return prisoner;
    }

    public String getSigUnderCon() {
        return sigUnderCon;
    }

    public void setSigUnderCon(String sigUnderCon) {
        this.sigUnderCon = sigUnderCon;
    }

    public String getNodeUnderCon() {
        return nodeUnderCon;
    }

    public void setNodeUnderCon(String nodeUnderCon) {
        this.nodeUnderCon = nodeUnderCon;
    }

    public void setLinks() {
        /* костыль
        в классе Report в measures записана ссылка на одну измеряемую Value
        возвращается с square brackets, которые удаляются вручную
         */
        setSigUnderCon(String.valueOf(getMeasures().keySet()).replaceAll("\\[|\\]", ""));
        NodeConnector prisoner = getDad().getNodeObj();
        setNodeUnderCon(prisoner.getRootName());
        assert prisoner!=null : "NOT FOUND NEEDED PRISONER VALUE";
        setPrisoner(prisoner);

        setTrip((Boolean) getPrisoner().getMeasures().get(getSigUnderCon()));
        System.out.println("");
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public Boolean getTrip() {
        return trip;
    }

    public void setTrip(Boolean trip) {
        this.trip = trip;
    }

    @Override
    public void start() {
          Thread thread = new Thread(() -> {
            while (order) {

                // парсинг конфигурации файла
                 if (!getPrisoner().getMeasures().get(sigUnderCon).equals(trip)) {
                    LogicalDevice ld =(LogicalDevice) getDadByType(SclClass.LD);
                    ArrayList<String> adList = ld.getReportAdresses();
                    IED ied = (IED) getDadByType(SclClass.IED);
                    String str = new EventNotification().build(setReport());
                    ied.getServer().sendEvent(str);
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    @Override
    public void stop() {

    }

    public String setReport(){
     String rep = "";
        RootClass cl = getDad();
     while (cl.getDad()!=null){
         rep+="$"+cl.getDad().getRootName();
         cl=cl.getDad();
     }
     rep+="$" + sigUnderCon;
     rep+="$" + nodeUnderCon;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        rep+="$"+ dtf.format(now);
     return rep;
    }
//
//    public void sendReport(){
//        logicalNode.getLogicalDevice().getIed().getMmsServer().buildMessage(ReportBuilder.build(underS));
//    }
}
