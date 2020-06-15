package ModelVMD;

import java.util.*;

/**
 * The VMD itself can be viewed as the object in which all other
 * MMS objects are contained. It has attributes that reflect general
 * capabilities and a general set of methods that are inherited by all
 * other MMS objects.
 */
public class VMD{

    // logic field access of potential services
    public enum logStatus {
        STATE_CHANGES_ALLOWED,
        NO_STATE_CHANGES_ALLOWED,
        LIMITED_SERVICES_SUPPORTED
    }

    // physical field of vmd condition
    public enum physStatus {
        OPERATIONAL,
        PARTIALLY_OPERATIONAL,
        INOPERABLE,
        NEEDS_COMMISSIONING
    }

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

    private logStatus logActStatus;
    private physStatus phys_actStatus;
    private ArrayList<capService> capList; // list of capabilities
    ArrayList<Object> progInvocList; // list of programm invocations
    private ArrayList<Object> domainList; //list of domains


    VMD(String venName, String modName, String rev,
        logStatus logSt, physStatus phSt, ArrayList<Object> domList){
        vendorName = venName;
        modelName = modName;
        revision = rev;
        logActStatus = logSt;
        phys_actStatus = phSt;
        domainList = domList;
        fillCapList(logActStatus);
    }

    private void fillCapList(logStatus ls){
        switch (logActStatus){
            case STATE_CHANGES_ALLOWED:
                break;
            case NO_STATE_CHANGES_ALLOWED:
                break;
            case LIMITED_SERVICES_SUPPORTED:
                break;
            default:
                break;
        }
    }

    String Identify(){return vendorName+" "+modelName+" "+revision;}

    ArrayList<capService> getCapabList(){
        return capList;
    }

    String Status(){return logActStatus.toString()+" "+phys_actStatus.toString();}

    ArrayList<Object> getNameList(){return domainList;}

    void rename(){
        Scanner in = new Scanner(System.in);
        System.out.print("VMD_OLD_NAME: ");
        String oldName = in.next();
        for (Object domain: domainList){

        }
        System.out.print("VMD_NEW_NAME: ");
        String newName = in.next();
        // TO DO
    }
}
