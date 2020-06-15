package MmsService.RequestServices.GetNameList;

import ASN_1.MyBerNode;
import MmsService.MyInterface;

/*
objectScope 		[1] CHOICE
		{
		vmdSpecific		[0] IMPLICIT NULL,
		domainSpecific		[1] IMPLICIT Identifier,
		aaSpecific		[2] IMPLICIT NULL
		},
 */

public class ObjectScope implements MyInterface {
    @Override
    public Object get(MyBerNode berNode) {
        switch (berNode.getId().getTag()) {
            case 0:
                return null;
            case 1:
                return null;
            default:
                return null;
        }
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
