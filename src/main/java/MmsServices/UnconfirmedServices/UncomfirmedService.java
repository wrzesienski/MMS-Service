package MmsServices.UnconfirmedServices;

import MmsServices.HighStructServiceBody;

/*
UnconfirmedService ::= CHOICE
	{
	informationReport		[0]	IMPLICIT InformationReport,
	unsolicitedStatus		[1]	IMPLICIT UnsolicitedStatus,
	eventNotification 		[2]	IMPLICIT EventNotification
-- XXX this one is neither in this ASN nor in the IMPORTS
--	additionalService		[3]	AdditionalUnconfirmedService
	}
 */

public class UncomfirmedService extends HighStructServiceBody {
    public UncomfirmedService() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
//                return new EventNotification
        }
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
