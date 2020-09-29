package CodeProcessing;

import IedStructure.IED;
import IedStructure.LogicalDevice;
import IedStructure.LogicalNode;
import IedStructure.RootClass;
import CodeProcessing.SclBodies.*;
import TerminalModel.CSWI.CSWI;
import TerminalModel.PDIS.PDIS;
import TerminalModel.SIMG.SIMG;
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
    public static void configIED(IED ied){
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, ied.getSclLink());
        TIED tied = scl.getIED().get(0);
        ArrayList<TS> services = tied.getServices().getServices();
        for (TS service: services){
                // костыль: добавляем названия открытых пользователю сервисов
                ied.addIedService(service.getSs());

        }
        ied.addChildList(getLDList(tied.getAccessPoint().get(0).getServer().getLDevice(), ied));

    }

    public static void configLD(LogicalDevice logicalDevice, TLDevice tlDevice){
        logicalDevice.addChildList(getLNList(tlDevice.getLN(), logicalDevice));
    }

    public static void configLN(LogicalNode logicalNode, TLN tln){
        logicalNode.addChild(setNode(logicalNode, tln.getLnClass().get(0), getValues(tln)));
        logicalNode.addChildList(configReport(logicalNode, tln.getReportControl()));
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
                return new PDIS(logicalNode, list);
            case "CSWI":
                return new CSWI(logicalNode, list);
            case "SIMG":
                return new SIMG(logicalNode, list);
                default:
                return null;
        }
    }

    public static ArrayList<RootClass> getLDList(List<TLDevice> tlDevices, IED ied){
        ArrayList<RootClass> logicalDevices = new ArrayList<>();
        int tag = 1;
        for (TLDevice tlDevice: tlDevices){
            LogicalDevice logicalDevice = new LogicalDevice(ied);
            logicalDevice.setRootName(ied.getRootName()+"$"+tlDevice.getInst());
            configLD(logicalDevice, tlDevice);
            logicalDevices.add(logicalDevice);
            tag++;
        }

        return logicalDevices;
    }

    public static ArrayList<RootClass> getLNList(List<TLN> tlnList, LogicalDevice logicalDevice){
        ArrayList<RootClass> logicalNodes = new ArrayList<>();
        for (TLN tln: tlnList){
            LogicalNode logicalNode = new LogicalNode(logicalDevice);
            logicalNode.setRootName(logicalDevice.getRootName()+"$" + tln.getLnType());
            configLN(logicalNode, tln);
            logicalNodes.add(logicalNode);
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
