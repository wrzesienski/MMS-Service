package MmsService.ResponceServices;

import ASN_1.MyBerNode;
import MmsService.MyInterface;

/*
GetCapabilityList-Response ::= SEQUENCE {
	listOfCapabilities	[0] IMPLICIT SEQUENCE OF VisibleString,
	moreFollows		[1] IMPLICIT BOOLEAN DEFAULT TRUE
	}
 */
public class GetCapabilityListResponce implements MyInterface {

    @Override
    public Object get(MyBerNode berNode) {
        return null;
    }

    @Override
    public MyBerNode convert() {
        return null;
    }
}
