package MmsService.RequestServices.VmdServices;

import ASN_1.MyBerNode;
import MmsService.MyInterface;
import MmsService.RequestServices.GetNameList.ObjectClass;
import MmsService.RequestServices.GetNameList.ObjectScope;

/*
GetNameList-Request ::= SEQUENCE
	{
		objectClass		[0] IMPLICIT INTEGER,
	objectScope 		[1] CHOICE,
	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
	}
 */


public class GetNameListRequest implements MyInterface {
    @Override
    public Object get(MyBerNode berNode) {
        switch (berNode.getId().getTag()){
            case 0:
                return new ObjectClass().get((MyBerNode) berNode.getContent());
            case 1:
                return new ObjectScope().get((MyBerNode) berNode.getContent());
        }
        return null;
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
