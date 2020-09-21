package MmsServices.UnconfirmedServices;

import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;

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
            case 2:
                return new EventNotification().process(getData(), getIed());
            case 0:
                return new ReportInfo().process(getData(), getIed());

        }
        return null;
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);
    }
}
