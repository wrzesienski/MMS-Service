package ModelVMD.VarAndTypeObj;

/**
 * This class of object is, in general, used for ”real-time” data
 * exchange. Its intended use is for data monitoring, non-historic
 * data reporting, and allowing data to be reported in an unsolicited
 * fashion.
 */
public class NamedVar {
    boolean mmsDeletable;
    NamedType type;
    String accessMethod;
}
