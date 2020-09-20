package MmsServices;

import MmsServices.AssociationServices.AssociationRequest;
import MmsServices.AssociationServices.AssociationResponce;
import MmsServices.CancelServices.CancelRequest;
import MmsServices.CancelServices.CancelResponce;
import MmsServices.Error.AssociationError;
import MmsServices.Error.CancelError;
import MmsServices.Error.ConfirmedError;
import MmsServices.Reject.Reject;
import MmsServices.RequestServices.ConfirmedRequest;
import MmsServices.ResponceServices.ConfirmedResponse;
import MmsServices.UnconfirmedServices.UncomfirmedService;

/**
 * header class of message processing
 */
public class MmsPDU extends HighStructServiceBody {

    public MmsPDU(){
        super(ServiceType.CHOICE);
    }


    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return new ConfirmedRequest().process(getData(), getIed());
            case 1:
                return new ConfirmedResponse().process(getData(), getIed());
            case 2:
                return new ConfirmedError().process(getData(), getIed());
            case 3:
                return new UncomfirmedService().process(getData(), getIed());
            case 4:
                return new Reject().process(getData(), getIed());
            case 5:
                return new CancelRequest().process(getData(), getIed());
            case 6:
                return new CancelResponce().process(getData(), getIed());
            case 7:
                return new CancelError().process(getData(), getIed());
            case 8:
                return new AssociationRequest().process(getData(), getIed());
            case 9:
                return new AssociationResponce().process(getData(), getIed());
            case 10:
                return new AssociationError().process(getData(), getIed());
            default: // add Error
                return "Error";
        }
    }

    @Override
    public String build(String data) {
        return data;
    }

}


