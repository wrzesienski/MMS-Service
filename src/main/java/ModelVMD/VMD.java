package ModelVMD;

import ModelVMD.ProgControlObj.Domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The VMD itself can be viewed as the object in which all other
 * MMS objects are contained. It has attributes that reflect general
 * capabilities and a general set of methods that are inherited by all
 * other MMS objects.
 */
public class VMD{

    private String logActStatus;
    private String phys_actStatus;

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
    private ArrayList<MmsObject> allList; // list of all objects


    public VMD(String venName, String modName, String rev,
               int logSt, int phSt, ArrayList<Domain> domList){
        vendorName = venName;
        modelName = modName;
        revision = rev;
        logActStatus = Integer.toString(logSt);
        phys_actStatus =  Integer.toString(phSt);
        domainList = domList;
        allList = new ArrayList<MmsObject>();
        allList.addAll(domList);
        allList.addAll(domList.get(0).getSubObjList());
//        fillCapList(logActStatus);
    }

    public void dom_create(ArrayList<Domain> domList){
        domainList.addAll(domList);
        allList.addAll(domList);
        allList.addAll(domList.get(0).getSubObjList());
    }

    public void obj_create(ArrayList<MmsObject> objList, String domName){
        for (Domain domain: domainList){
            if(domName.equals(domain.getObjName())){
                domain.setSubObjList(objList);
            }
        }
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

    public ArrayList<String> identify(int tag) {
        switch (tag) {
            case 0:
                return new ArrayList<>(Arrays.asList(vendorName, "0"));
            case 1:
                return new ArrayList<>(Arrays.asList(modelName, "1"));
            case 2:
                return new ArrayList<>(Arrays.asList(revision, "2"));
            case 3:
                return new ArrayList<>(Arrays.asList(vendorName, "0",
                        modelName, "1",
                        "2", revision));
            default:
                return null;
        }
    }

    public ArrayList<capService> getCapabList(){
        return capList;
    }

    public ArrayList<String> status(){return new ArrayList<String>(Arrays.asList(logActStatus, "0", phys_actStatus, "1"));}

    /**
     * method returns object in vmdSpecific field
     * @return
     */

    // TO DO return ObjectName!!!!!!!!!!!!
    public ArrayList<MmsObject> getNameList(){
        return allList;
    }

    /**
     * method returns all vars in specific domain field
     * @param domName
     * @return
     */
    public ArrayList<MmsObject> getNameList(String domName){
//        return (MMSVar) domainList;
//        for(Domain domain: domainList){
//            if (domain.getObjName().equals(domName))
//                return domain.getSubObjList();
//        }
        return null;
    }

    /**
     * method returns all vars in specific type field
     * @param type
     * @return
     */

    // TO DO return ObjectName!!!!!!!!!!!!
    public ArrayList<MmsObject> getNameList(MmsObjectType type){
        if (type==MmsObjectType.VMD_SPECIFIC){
            return getNameList();
        }
        ArrayList<MmsObject> list = new ArrayList<>();
        for(Domain domain: domainList){
            for (MmsObject var: domain.getSubObjList()){
                if (var.getType()==type)
                    list.add(var);
            }

        }
        return list;
    }

    public void rename(String cap){
        String[] a = cap.split(" ");
        for (MmsObject var: allList){
            if(Integer.parseInt(a[0])==var.getType().getCode() & a[1].equals(var.getObjName())){
                var.setObjName(a[2]);
            }
        }

    }

}
