package IecStructure;

import Connect.MmsServer;
import TerminalModel.ReportControl;

import java.io.IOException;
import java.util.List;


/**
 * class of modeling ied body by iec61850 protocol
 */
public class IED {

    public IED(){}
    private MmsServer mmsServer = new MmsServer(this);
    private List<IedService> iedService;
    private List<LogicalDevice> logicalDevices;

    public MmsServer getMmsServer() {
        return mmsServer;
    }

    public void setMmsServer(MmsServer mmsServer) {
        this.mmsServer = mmsServer;
    }

    public List<IedService> getIedService() {
        return iedService;
    }

    public void setIedService(List<IedService> iedService) {
        this.iedService = iedService;
    }

    public List<LogicalDevice> getLogicalDevices() {
        return logicalDevices;
    }

    public void setLogicalDevices(List<LogicalDevice> logicalDevices) {
        this.logicalDevices = logicalDevices;
    }



    IED(List<IedService> iedService, List<LogicalDevice> logicalDevices){
        this.iedService = iedService;
        this.logicalDevices = logicalDevices;
    };


    public void start() throws IOException {

        mmsServer.start();
        for (LogicalDevice logicalDevice: logicalDevices){
            for(LogicalNode logicalNode: logicalDevice.getLogicalNodeList()){
                for(ReportControl reportControl: logicalNode.getReportControls()){
                    reportControl.start();
                }
                logicalNode.getMm().start();
            }
        }
    }





}
