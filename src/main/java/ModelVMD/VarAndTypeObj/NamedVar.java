package ModelVMD.VarAndTypeObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

/**
 * This class of object is, in general, used for ”real-time” data
 * exchange. Its intended use is for data monitoring, non-historic
 * data reporting, and allowing data to be reported in an unsolicited
 * fashion.
 */
public class NamedVar extends MMSVar {

    boolean mmsDeletable;
    NamedType type;
    String accessMethod;

    public NamedVar(String name){
        setObjName(name);
        setType(MmsObjectType.NAMED_VAR);
    }
}
