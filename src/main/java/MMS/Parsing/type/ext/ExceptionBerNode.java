package MMS.Parsing.type.ext;

public class ExceptionBerNode extends FakeBerNode {

    @Override
    public String getValueAsString() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getAsn1TypeDesc() {
        return null;
    }

    public ExceptionBerNode deepCopy() {
        ExceptionBerNode node = new ExceptionBerNode();
        return node;
    }

}
