package ModelVMD.VarAndTypeObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class NamedType extends MMSVar {

    NamedType(String name){
        setObjName(name);
        setType(MmsObjectType.NAMED_TYPE);
    }

    boolean mmsDeletable;

}
