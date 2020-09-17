package TerminalModel;

import IecStructure.LogicalNode;
import TerminalModel.PDIS.MmsConnector;

import java.util.ArrayList;

public class ReportControl extends MmsConnector {

    private LogicalNode logicalNode;
    public ReportControl(LogicalNode logicalNode){
        this.logicalNode = logicalNode;
    }
    private Boolean measShit;

    public String getUnderS() {
        return underS;
    }

    public void setUnderS(String underS) {
        this.underS = underS;
    }

    private String underS;
    private String meanName;
    private String trip;
    private boolean iniMean;

    public void setMeanShit(String underS) {
        setUnderS(underS);
        iniMean = (Boolean) logicalNode.getMeasruments().get(underS);

    }

    public String getMeanName() {
        return meanName;
    }

    public void setMeanName(String meanName) {
        this.meanName = meanName;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    @Override
    public void start() {
        Thread thread = new Thread(() -> {
            while (true) {

                // парсинг конфигурации файла
                if (!logicalNode.getMeasruments().get(underS).equals(iniMean)) {
                    System.out.println("oo");
                    ArrayList<String> adList = logicalNode.getLogicalDevice().getReportAdresses();
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
//
//    public void sendReport(){
//        logicalNode.getLogicalDevice().getIed().getMmsServer().buildMessage(ReportBuilder.build(underS));
//    }
}
