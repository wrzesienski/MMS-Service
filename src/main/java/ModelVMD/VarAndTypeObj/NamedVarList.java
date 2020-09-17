package ModelVMD.VarAndTypeObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

public class NamedVarList extends MmsObject {

    NamedVarList(String name){
        setObjName(name);
        setType(MmsObjectType.NAMED_VAR_LIST);
    }
}
