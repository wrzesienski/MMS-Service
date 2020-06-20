package ModelVMD;


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

public enum MmsObjectType {
    NAMED_VAR(0),
    SCATTERED_ACCESS(1),
    NAMED_VAR_LIST(2),
    NAMED_TYPE(3),
    SEMAPHORE(4),
    EVENT_CONDITION(5),
    EVENT_ACTION(6),
    EVENT_ENROLLMENT(7),
    JOURNAL(8),
    DOMAIN(9),
    OPERATOR_STATION(10),
    VMD_SPECIFIC(11);

    private int code;
    MmsObjectType(int code){
        this.code = code;
    }
    public int getCode(){ return code;}

}
