package ASN_1;

public class MyBerNode {

    Identifier id;
    String length;
    Object content;

    public MyBerNode(){
        id = new Identifier();
        length = "";
        content = null;
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
