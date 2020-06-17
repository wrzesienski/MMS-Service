package MmsService;

import ASN_1.Identifier;
import ASN_1.BerNode;

public class Data {


    public static BerNode convert(Object obj){
        BerNode berNode = new BerNode();
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
