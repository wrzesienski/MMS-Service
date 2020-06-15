package MmsService;

import ASN_1.MyBerNode;

public class VariableAccessSpecification {


    static Object get(MyBerNode berNode){
        switch (berNode.getId().getTag()){
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            default:
                return null;
        }
    }
}
