package ModelVMD.VarAndTypeObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

public class Address extends MmsObject {

    public Address() {

    }

    public Address(String name){
        setObjName(name);
        setType(MmsObjectType.SCATTERED_ACCESS);
    }
}
