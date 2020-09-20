package CodeProcessing;

import IedStructure.IED;
import IedStructure.LogicalDevice;
import IedStructure.LogicalNode;
import IedStructure.RootClass;
import SclBodies.*;
import TerminalModel.CSWI.SwitchResearcher;
import TerminalModel.PDIS.ProcessDataManager;
import TerminalModel.SIMG.HF_Measurement;
import TerminalModel.URCB.ReportControl;

import java.util.ArrayList;
import java.util.List;

/**
 * класс обработки SCL файла и создания IED модели
 */
public class IedConfigurator {

    /**
     * конфигурируем IED
     * @param ied объект ied
     */
    public static void configIed(IED ied){
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, ied.getSclLink());
        TIED tied = scl.getIED().get(0);
        ArrayList<TS> services = tied.getServices().getServices();
        for (TS service: services){
                // костыль: добавляем названия открытых пользователю сервисов
                ied.addIedService(service.getSs());

        }
        ied.addChilds(getLDList(tied.getAccessPoint().get(0).getServer().getLDevice(), ied));

    }

    public static void configLD(LogicalDevice logicalDevice, TLDevice tlDevice){
        logicalDevice.setRootName(tlDevice.getInst());
        logicalDevice.addChilds(getLNList(tlDevice.getLN(), logicalDevice));
    }

    public static void configLN(LogicalNode logicalNode, TLN tln){
        logicalNode.setRootName(tln.getLnType());
        logicalNode.addChild(setNode(logicalNode, tln.getLnClass().get(0), getValues(tln)));
        logicalNode.addChilds(configReport(logicalNode, tln.getReportControl()));
    }

    public static ArrayList<RootClass> configReport(LogicalNode logicalNode, List<TReportControl> treportControls){
        ArrayList<RootClass> reportControls = new ArrayList<>();
        int tag = 1;
        for(TReportControl tReportControl: treportControls){
            ReportControl reportControl = new ReportControl(logicalNode, tReportControl.getDatSet());
            reportControl.setLinks();
            reportControls.add(reportControl);
            tag++;
        }
        return reportControls;
    }

    // метод обработки scl узлов по их классу и создание модели соответсвующего класса
    public static RootClass setNode(LogicalNode logicalNode, String nodeClass, ArrayList<String> list){
        switch (nodeClass){
            case "PDIS":
                return new ProcessDataManager(logicalNode, list);
            case "CSWI":
                return new SwitchResearcher(logicalNode, list);
            case "SIMG":
                return new HF_Measurement(logicalNode, list);
                default:
                return null;
        }
    }

    public static ArrayList<RootClass> getLDList(List<TLDevice> tlDevices, IED ied){
        ArrayList<RootClass> logicalDevices = new ArrayList<>();
        int tag = 1;
        for (TLDevice tlDevice: tlDevices){
            LogicalDevice logicalDevice = new LogicalDevice(ied);
            configLD(logicalDevice, tlDevice);
            logicalDevices.add(logicalDevice);
            tag++;
        }

        return logicalDevices;
    }

    public static ArrayList<RootClass> getLNList(List<TLN> tlnList, LogicalDevice logicalDevice){
        ArrayList<RootClass> logicalNodes = new ArrayList<>();
        int tag = 1;
        for (TLN tln: tlnList){
            LogicalNode logicalNode = new LogicalNode(logicalDevice);
            logicalNode.setRootName(tln.getLnClass().get(0));
            configLN(logicalNode, tln);
            logicalNodes.add(logicalNode);
            tag++;
        }
        return logicalNodes;
    }

    public static ArrayList<String> getValues(TLN tlogicalNode){
        ArrayList<String> list = new ArrayList<>();
        for (TDOI tdoi: tlogicalNode.getDOI()){
            list.add(tdoi.getName());
        }
        return list;
    }
}
