package ModelVMD.VmdStatus;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;
import ModelVMD.ProgControlObj.Domain;

import java.util.*;

/**
 * The VMD itself can be viewed as the object in which all other
 * MMS objects are contained. It has attributes that reflect general
 * capabilities and a general set of methods that are inherited by all
 * other MMS objects.
 */
public class VMD{


    private int logActStatus;
    private int phys_actStatus;

    public enum capService {
        Status,
        Identify,
        GetNamedList,
        Rename
    }

    String execFunc; // ??

    // **** model information
    private String vendorName;
    private String modelName; // vmd name
    private String revision;
    // ****


    private ArrayList<capService> capList; // list of capabilities
    ArrayList<Object> progInvocList; // list of programm invocations
    private ArrayList<Domain> domainList; //list of domains


    public VMD(String venName, String modName, String rev,
               int logSt, int phSt, ArrayList<Domain> domList){
        vendorName = venName;
        modelName = modName;
        revision = rev;
        logActStatus = logSt;
        phys_actStatus = phSt;
        domainList = domList;
//        fillCapList(logActStatus);
    }

//    private void fillCapList(LogStatus ls){
//        switch (logActStatus){
//            case STATE_CHANGES_ALLOWED:
//                break;
//            case NO_STATE_CHANGES_ALLOWED:
//                break;
//            case LIMITED_SERVICES_SUPPORTED:
//                break;
//            default:
//                break;
//        }
//    }

    public String identify(){return vendorName+" "+modelName+" "+revision;}

    public ArrayList<capService> getCapabList(){
        return capList;
    }

    public String status(){return logActStatus+", "+phys_actStatus;}

    /**
     * method returns object in vmdSpecific field
     * @return
     */

    // TO DO return ObjectName!!!!!!!!!!!!
    public ArrayList<String> getNameList(){
        ArrayList<String> vmdVarList = new ArrayList<>();
        for (Domain domain: domainList){
            vmdVarList.addAll(domain.getDomContentNameList());
        }
        return vmdVarList;
    }

    /**
     * method returns all vars in specific domain field
     * @param domName
     * @return
     */
    // TO DO return ObjectName!!!!!!!!!!!!
    public ArrayList<String> getNameList(String domName){
        for(Domain domain: domainList){
            if (domain.getObjName().equals(domName))
                return domain.getDomContentNameList();
        }
        return null;
    }

    /**
     * method returns all vars in specific type field
     * @param type
     * @return
     */

    // TO DO return ObjectName!!!!!!!!!!!!
    public ArrayList<String> getNameList(MmsObjectType type){
        ArrayList<String> list = new ArrayList<>();
        for(Domain domain: domainList){
            for (MMSVar var: domain.getSubObjList()){
                if (var.getType()==type)
                    list.add(var.getObjName());
            }

        }
        return list;
    }

//    public void rename(String ){

//    }
}
