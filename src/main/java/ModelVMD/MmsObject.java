package ModelVMD;

public abstract class MmsObject {

    private MmsObjectType type;
    private String objName;
    private boolean MmsDeletable = false;

    public boolean isMmsDeletable() {
        return MmsDeletable;
    }

    public void setMmsDeletable(boolean mmsDeletable) {
        MmsDeletable = mmsDeletable;
    }


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
