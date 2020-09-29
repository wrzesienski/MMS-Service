package TerminalModel.URCB;

import IedStructure.*;
import MmsServices.UnconfirmedServices.EventNotification;
import TerminalModel.NodeConnector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * class of event notification
 */
public class ReportControl extends NodeConnector {
    private String sigUnderCon; // signal under control
    private String nodeUnderCon; // node name under control
    private boolean trip;
    private boolean order;
    private NodeConnector prisoner; // controlled node

    public ReportControl(LogicalNode logicalNode, String underCon){
        super(logicalNode, new ArrayList<String>(Collections.singleton(underCon)));
        order = true;
    }

    public ReportControl(LogicalNode ln){
        this(ln, null);
        order = true;
        setType(SclClass.REPORT);
    }

    private void setPrisoner(NodeConnector prisoner){
        this.prisoner = prisoner;
    }

    private NodeConnector getPrisoner(){
        return prisoner;
    }

    public String getSigUnderCon() {
        return sigUnderCon;
    }

    private void setSigUnderCon(String sigUnderCon) {
        this.sigUnderCon = sigUnderCon;
    }

    public String getNodeUnderCon() {
        return nodeUnderCon;
    }

    private void setNodeUnderCon(String nodeUnderCon) {
        this.nodeUnderCon = nodeUnderCon;
    }

    public void setLinks() {
        /* костыль
        в классе Report в measures записана ссылка на одну измеряемую Value
        возвращается с square brackets, которые удаляются вручную
         */
        setSigUnderCon(String.valueOf(getDataNameList().get(0)));
        NodeConnector prisoner = getDad().getNodeObj();
        setNodeUnderCon(prisoner.getRootName());
        assert prisoner!=null : "NOT FOUND NEEDED PRISONER VALUE";
        setPrisoner(prisoner);

        setTrip((Boolean) getPrisoner().getDataByName(sigUnderCon).getMean());
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
            while (order) { // пока не скажут замолчать

                // парсинг конфигурации файла
                if (!((Boolean.parseBoolean(String.valueOf(
                        // если наблюдаемая величина изменила свое значение с дефолтного
                        getPrisoner().getDataByName(sigUnderCon).getMean())))== trip)) {

                    System.out.println("Event started!");
                    IED ied = (IED) getDadByType(SclClass.IED);
                    String event = makeReport(); // создаем отчет по событию
                    ((IED) getDadByType(SclClass.IED)).addToJournal(event); // запись в лог событий
                    String str = new EventNotification().build(event); // создание оповещения клиенту
                    ied.getServer().sendMessage(str); // отправка сообщения о событии

                    try { // засыпаем на 10с
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try { // засыпаем на 10с
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
          });
        thread.start();
    }

    @Override
    public void configData() {

    }

    @Override
    public void stop() {

    }

    /**
     * метод отправки отчетов
     * @return
     */
    private String makeReport(){
     StringBuilder rep = new StringBuilder();
        rep.append("_").append(sigUnderCon);
        rep.append("_").append(nodeUnderCon);
        RootClass cl = getDad();
     while (cl.getDad()!=null){
         rep.append("_").append(cl.getRootName());
         cl=cl.getDad();
     }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd$HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        rep.append("_").append(dtf.format(now));
     return rep.toString();
    }
//
//    public void sendReport(){
//        logicalNode.getLogicalDevice().getIed().getMmsServer().buildMessage(ReportBuilder.build(underS));
//    }
}
