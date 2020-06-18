package MmsService.RequestServices.VariablesSevices;

import MmsService.RequestService;

/*
Read-Request ::= SEQUENCE
	{
	specificationWithResult		[0] IMPLICIT BOOLEAN DEFAULT FALSE,
	variableAccessSpecificatn	[1] VariableAccessSpecification
	}
 */

public class ReadRequest extends RequestService {


    public ReadRequest(){
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                return "0";
            case 1:
                return "1";
            default:
                return "2";
        }
    }

    @Override
    public String build(String data) {
        return null;
    }
}
