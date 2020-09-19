package MmsServices.RequestServices;

import MmsServices.HighStructServiceBody;

/*
GetNameList-Request ::= SEQUENCE
	{
	objectClass		[0] IMPLICIT INTEGER,
	objectScope 		[1] CHOICE,
	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
	}
 */


public class GetNameListRequest extends HighStructServiceBody {

    public GetNameListRequest() {
        super(ServiceType.SEQUENCE);
    }

    public GetNameListRequest(String link) {
        super(ServiceType.SEQUENCE);
        setTextStructLink(link);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                return new ObjectClass().process(getData(), getIed());
            case 1:
                return new ObjectScope().process(getData(), getIed());
        }
        return null;
    }

    @Override
    public String build(String data) {
        return null;
//        return BuildPointer.getParent(this, data);
    }
}
