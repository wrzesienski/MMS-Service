package MmsService;

import ASN_1.Identifier;
import ASN_1.MyBerNode;

public class Data {


    public static MyBerNode convert(Object obj){
        MyBerNode berNode = new MyBerNode();
        Identifier id = new Identifier();
        id.setTag(0);
        id.setStruct(0);
        id.setType(0);
        berNode.setId(id);
//        berNode.setContent(obj);
//        MyBerNode anNode = ConfirmedResponsePDU.convert();
//        anNode.setContent(berNode);
//        return anNode;
        return null;
    }
}
