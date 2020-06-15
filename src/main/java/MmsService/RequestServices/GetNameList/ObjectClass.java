package MmsService.RequestServices.GetNameList;

import ASN_1.MyBerNode;
import MmsService.MyInterface;

/*
		objectClass		[0] IMPLICIT INTEGER
			{
			nammedVariable		(0),
			scatteredAccess		(1),
			namedVariableList	(2),
			namedType		(3),
			semaphore		(4),
			eventCondition		(5),
			eventAction		(6),
			eventEnrollment		(7),
			journal			(8),
			domain			(9),
			programInvocation	(10),
			operatorStation		(11)
			}
 */

public class ObjectClass implements MyInterface {

    @Override
    public Object get(MyBerNode berNode) {
        switch (berNode.getId().getTag()){
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return null;
            case 7:
                return null;
            case 8:
                return null;
            case 9:
                return null;
            case 10:
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
