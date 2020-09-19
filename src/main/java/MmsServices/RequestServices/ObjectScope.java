package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.DownStructServiceBody;

/*
objectScope 		[1] CHOICE
		{
		vmdSpecific		[0] IMPLICIT NULL,
		domainSpecific		[1] IMPLICIT Identifier,
		aaSpecific		[2] IMPLICIT NULL
		},
 */

public class ObjectScope extends DownStructServiceBody {

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return null;
            default:
                return "Error";
        }
    }

    @Override
    public String build(String data) {
        return CodeTypeConverter.stickMessage(data, CodeTypeConverter.stickId(0,0, 1));
    }
//
//    @Override
//    public String process(String data, IED ied) {
//
//    }
}
