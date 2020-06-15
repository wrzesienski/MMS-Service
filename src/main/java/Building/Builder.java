package Building;

import ASN_1.MyBerNode;
import MmsService.Data;
import MmsService.MMMService;

public class Builder {


    public static MyBerNode build(Object ob){
        return Data.convert(ob);
    }

    public static Object process(MyBerNode berNode){

        switch (berNode.getId().getTag()){
            case 0:
                return (Object) MMMService.get((MyBerNode) berNode.getContent());
            case 1:
                return null;
            default:
                return null;
        }
    }
}
