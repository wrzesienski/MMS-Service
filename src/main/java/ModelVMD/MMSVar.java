package ModelVMD;

public abstract class MMSVar {

    private MmsObjectType type;
    private String objName;

    public MmsObjectType getType() {
        return type;
    }

    public void setType(MmsObjectType type) {
        this.type = type;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }
}
