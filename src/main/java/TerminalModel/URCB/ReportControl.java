package TerminalModel.URCB;

import IecStructure.LogicalDevice;
import IecStructure.LogicalNode;
import IecStructure.SclClass;
import TerminalModel.NodeConnector;

import java.util.ArrayList;
import java.util.Collections;

public class ReportControl extends NodeConnector {
    private String sigUnderCon;
    private String nodeUnderCon;
    private boolean trip;
    private boolean order;
    private LogicalNode logicalNode;
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

    public void setLinks(String node) {
        /* костыль
        в классе Report в measures записана ссылка на одну измеряемую Value
        возвращается с square brackets, которые удаляются вручную
         */
        setSigUnderCon(String.valueOf(getMeasures().keySet()).replaceAll("\\[|\\]", ""));
        setNodeUnderCon(node);
        NodeConnector prisoner = getDad().getNodeObj();
        assert prisoner!=null : "NOT FOUND NEEDED PRISONER VALUE";
        setPrisoner(prisoner);
        setTrip((Boolean) getPrisoner().getMeasures().get(getSigUnderCon()));
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
                    System.out.println("oo");
                    LogicalDevice ld =(LogicalDevice) getDadByType(SclClass.LD);
                    ArrayList<String> adList = ld.getReportAdresses();
                     if(adList!=null){
//                        sendReport();

                    }
                }
                try {
                    Thread.sleep(1000);
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
//
//    public void sendReport(){
//        logicalNode.getLogicalDevice().getIed().getMmsServer().buildMessage(ReportBuilder.build(underS));
//    }
}
