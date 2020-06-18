package MmsService.RequestServices.VmdServices.GetNameList;

import MmsService.AbstractService;
import ModelVMD.MmsObjectType;
import res.IDK;

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

public class ObjectClass extends AbstractService {

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return IDK.vmd.getNameList(MmsObjectType.NAMED_VAR).toString();
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
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data) {
        return null;
    }

}
