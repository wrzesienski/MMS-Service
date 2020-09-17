package ModelVMD.VarAndTypeObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

public class NamedType extends MmsObject {

    NamedType(String name){
        setObjName(name);
        setType(MmsObjectType.NAMED_TYPE);
    }

    boolean mmsDeletable;

}
