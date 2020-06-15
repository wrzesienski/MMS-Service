package MmsService;

import ASN_1.Identifier;
import ASN_1.MyBerNode;

public class ConfirmedResponsePDU implements MyInterface{

    public Object get(MyBerNode berNode) {
        return null;
    }

    public MyBerNode convert(){
        MyBerNode berNode = new MyBerNode();
        Identifier id = new Identifier();
        id.setTag(1);
        id.setStruct(1);
        id.setType(1);
        berNode.setId(id);
        return berNode;
    }
}
