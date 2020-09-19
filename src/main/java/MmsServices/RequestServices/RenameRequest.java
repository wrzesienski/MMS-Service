package MmsServices.RequestServices;

import IecStructure.IED;
import MmsServices.AbstractService;

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

public class RenameRequest extends AbstractService {

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
//                IDK.vmd.rename();
                return null;
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data, IED ied) {
        String[] splitData;
        boolean flag = true;
        String dataa = "";
        while (flag){

            splitData = data.split(" ", 3);
            if(1==splitData[2].length()) {
                flag = false;
            }
            data = splitData[2].split(" ", 2)[1];
            dataa+= splitData[2].split(" ", 2)[0] + " ";
        }
//        IDK.vmd.rename(dataa);
        return null;
    }
}