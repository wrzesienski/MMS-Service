package MmsService.RequestServices.VmdServices;

import ASN_1.MyBerNode;
import MmsService.MyInterface;

/*
Rename-Request ::= SEQUENCE
	{
	extendedObjectClass	[0] CHOICE {
	objectClass			[0] IMPLICIT INTEGER
		{
		namedVariable		(0),
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

	    },
	currentName 		[1] ObjectName,
	newIdentifier		[2] IMPLICIT Identifier
      	}
 */

public class RenameRequest implements MyInterface {
    @Override
    public Object get(MyBerNode berNode) {
        return null;
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
