package MmsService.ResponceServices.VmdServices;

/*
GetCapabilityList-Response ::= SEQUENCE {
	listOfCapabilities	[0] IMPLICIT SEQUENCE OF VisibleString,
	moreFollows		[1] IMPLICIT BOOLEAN DEFAULT TRUE
	}
 */

import MmsService.ServiceInterface;

public class GetCapabilityListResponse {
    /*
        GetCapabilityList-Response ::= SEQUENCE {
            listOfCapabilities	[0] IMPLICIT SEQUENCE OF VisibleString,
            moreFollows		[1] IMPLICIT BOOLEAN DEFAULT TRUE
            }
         */
    public static class GetCapabilityListResponce implements ServiceInterface {
        @Override
        public String choice(int tag) {
            return null;
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
}
