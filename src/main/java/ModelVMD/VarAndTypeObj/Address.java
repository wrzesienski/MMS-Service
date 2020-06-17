package ModelVMD.VarAndTypeObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class Address extends MMSVar{

    public Address() {

    }

    public Address(String name){
        setObjName(name);
        setType(MmsObjectType.ADDRESS);
    }
}
