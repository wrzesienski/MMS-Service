package MmsService.RequestServices.VmdServices.GetNameList;

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

public class ObjectClass extends AbstractObjectChoice {

    public ObjectClass() {
        setService(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
            case 1:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.OPERATOR_STATION));
            case 2:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR_LIST));
            case 3:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_TYPE));
            case 4:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.SEMAPHORE));
            case 5:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.EVENT_CONDITION));
            case 6:
                return null;
            case 7:
                return null;
            case 8:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.JOURNAL));
            case 9:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.DOMAIN));
            case 10:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
            case 11:
                return dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return null;
    }

    /*
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
     */
}
