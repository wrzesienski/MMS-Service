package IecStructure;

import BerCoding.WorkWithConfigurationFiles;
import TerminalModel.CSWI.SwitchResearcher;
import TerminalModel.ReportControl;
import TerminalModel.SIMG.HF_Measurement;
import TerminalModel.PDIS.MmsConnector;
import TerminalModel.PDIS.ProcessDataManager;
import ru.smarteps.scl.*;

import java.util.ArrayList;
import java.util.List;

public class SclParser {

    public static void configSys(IED ied, String sclFile){
        SCL scl = WorkWithConfigurationFiles.unMarshalAny(SCL.class, sclFile);
//        TIED tied = WorkWithConfigurationFiles.unMarshalAny(SCL.class, sclFile).getIED().get(0);
        TIED tied = scl.getIED().get(0);
        ied.setLogicalDevices(sortLD(tied.getAccessPoint().get(0).getServer().getLDevice(), ied));

    }

    public static List<LogicalDevice> sortLD(List<TLDevice> tlDevices, IED ied){
        ArrayList<LogicalDevice> logicalDevices = new ArrayList<>();
        for (TLDevice tlDevice: tlDevices){
            LogicalDevice logicalDevice = new LogicalDevice(ied);
            configLD(logicalDevice, tlDevice);
            logicalDevices.add(logicalDevice);
        }

        return logicalDevices;
    }

    public static void configLD(LogicalDevice logicalDevice, TLDevice tlDevice){
        logicalDevice.setName(tlDevice.getInst());
        logicalDevice.setLogicalNodeList(sortLN(tlDevice.getLN(), logicalDevice));
    }


    public static List<LogicalNode> sortLN(List<TLN> tlnList, LogicalDevice logicalDevice){
        ArrayList<LogicalNode> logicalNodes = new ArrayList<>();
        for (TLN tln: tlnList){
            LogicalNode logicalNode = new LogicalNode(logicalDevice);
            logicalNode.setNodeName(tln.getLnClass().get(0));
            configLN(logicalNode, tln);
            logicalNodes.add(logicalNode);
        }

        return logicalNodes;
    }

    public static void configLN(LogicalNode logicalNode, TLN tln){
        logicalNode.setMm(setNode(logicalNode, tln.getLnClass(), getMesa(tln)));
//        tln.setDoi(rrr(logicalNode.getMeasruments()));
        logicalNode.setReportControls(configRepCon(logicalNode, tln.getReportControl()));
    }

//    public static List<TDOI> rrr(HashMap<String, Object> objects){
//        ArrayList<TDOI> tdois = new ArrayList<>();
//        for(int i=0;i<=objects.size();i++){
//            Object obj = objects.get(1);
//            TDOI tdoi = new TDOI();
//            tdoi.setName(obj.getName());
//            tdoi.set
//        }
//    }

    public static List<ReportControl> configRepCon(LogicalNode logicalNode, List<TReportControl> treportControls){
        ArrayList<ReportControl> reportControls = new ArrayList<>();
        for(TReportControl tReportControl: treportControls){
            ReportControl reportControl = new ReportControl(logicalNode);
            reportControl.setMeanShit(tReportControl.getDatSet());
            reportControls.add(reportControl);
        }
        return reportControls;
    }

    public static MmsConnector setNode(LogicalNode logicalNode, List<String> nodeClass, List<String> list){
        switch (nodeClass.get(0)){
            case "PDIS":
                return new ProcessDataManager(logicalNode, list);
            case "LPHD":
                return null;
            case "CSWI":
                return new SwitchResearcher(logicalNode, (ArrayList<String>) list);
            case "SIMG":
                return new HF_Measurement(logicalNode, (ArrayList<String>) list);
                default:
                return null;
        }
    }

    public static ArrayList<String> getMesa(TLN tlogicalNode){
        ArrayList<String> list = new ArrayList<>();
        for (TDOI tdoi: tlogicalNode.getDOI()){
            list.add(tdoi.getName());
        }
        return list;
    }
}
