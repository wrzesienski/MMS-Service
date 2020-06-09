package ModelVMD;

import ModelVMD.ProgControlObj.Domain;
import ModelVMD.ProgControlObj.ProgInvocation;

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
        TATE_CHANGES_ALLOWED,
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
    String vendorName;
    String modelName; // vmd name
    String revision;
    // ****

    logStatus log_actStatus;
    physStatus phys_actStatus;
    ArrayList<capService> capList; // list of capabilities
    ArrayList<Object> progInvocList; // list of programm invocations
    ArrayList<Object> domainList; //list of domains

    private HashMap<String, Object> vmdVolume;

    VMD(String name){
        vmdVolume = new HashMap<String, Object>();
    }

    //*************
    String Identify(){return "";}
    String getCapabList(){return "";}
    String Status(){return "";}
    ArrayList<Object> getNameList(){return null;}
    void rename(){
        Scanner in = new Scanner(System.in);
        System.out.print("OLD_NAME: ");
        String oldName = in.next();
        System.out.print("NEW_NAME: ");
        String newName = in.next();
        // TO DO
    }
    //**************

    public Object get(String objName) {
        return vmdVolume.get(objName);
    }

    public void set(Object someObj) {
    }

    public void addToMap(String objName, Object someObj){
        vmdVolume.put(objName, someObj);
    }

    public Object[] getQueryAttributes() {
        return new Object[0];
    }

    public void rename(String objOldName, String objNewName) {
        Object obj = vmdVolume.remove(objOldName);
        vmdVolume.put(objNewName, obj);
    }

    public void destroy(String objName) {
        vmdVolume.remove(objName);
    }
}
