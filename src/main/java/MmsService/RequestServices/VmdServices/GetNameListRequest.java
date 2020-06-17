package MmsService.RequestServices.VmdServices;

import MmsService.RequestService;
import MmsService.RequestServices.VmdServices.GetNameList.ObjectClass;
import MmsService.RequestServices.VmdServices.GetNameList.ObjectScope;
import ModelVMD.VMD;

/*
GetNameList-Request ::= SEQUENCE
	{
	objectClass		[0] IMPLICIT INTEGER,
	objectScope 		[1] CHOICE,
	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
	}
 */


public class GetNameListRequest extends RequestService {

    public GetNameListRequest(VMD vmd) {
        super(vmd, ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                return new ObjectClass(getVmd()).process(getData());
            case 1:
                return new ObjectScope(getVmd()).process(getData());
        }
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
