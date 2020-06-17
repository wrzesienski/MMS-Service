package ModelVMD.VarAndTypeObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class NamedVarList extends MMSVar {

    NamedVarList(String name){
        setObjName(name);
        setType(MmsObjectType.NAMED_VAR_LIST);
    }
}
