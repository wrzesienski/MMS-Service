package MmsService.RequestServices.VariablesSevices;

import ASN_1.MyBerNode;
import MmsService.Data;
import MmsService.MyInterface;

public class ReadRequest implements MyInterface {

    public Object get(MyBerNode berNode){
        switch (berNode.getId().getTag()){
            case 0:
                return new Data();
            case 1:
                return "1";
            default:
                return "2";
        }
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
