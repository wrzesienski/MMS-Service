package MmsServices.RequestServices;

import MmsServices.BuildPointer;
import MmsServices.HighStructServiceBody;

/*
Identify-Response ::= SEQUENCE {
	vendorName		[0] IMPLICIT VisibleString,
	modelName		[1] IMPLICIT VisibleString,
	revision		[2] IMPLICIT VisibleString,
	listOfAbstractSyntaxes	[3] IMPLICIT SEQUENCE OF OBJECT IDENTIFIER OPTIONAL
	}
 */

public class IdentifyRequest extends HighStructServiceBody {

    public IdentifyRequest() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
//                return CodeTypeConverter.s_dataToHex(IDK.vmd.identify(tag));
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this, data);
    }
}
