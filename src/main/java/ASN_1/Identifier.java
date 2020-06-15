package ASN_1;

public class Identifier {

    int type;
    int struct;
    int tag;

    public Identifier(){
        type = 0;
        struct = 0;
        tag = 0;
    }

    public int getStruct() {
        return struct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setStruct(int struct) {
        this.struct = struct;
    }
}
