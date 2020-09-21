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

        System.out.println("MMSpdu ::= CHOICE\n" +
                "\t{\n" +
                "\tconfirmed-RequestPDU\t[0] \tIMPLICIT Confirmed-RequestPDU,\n" +
                "\tconfirmed-ResponsePDU\t[1] \tIMPLICIT Confirmed-ResponsePDU,\n" +
                "\tconfirmed-ErrorPDU\t\t[2] \tIMPLICIT Confirmed-ErrorPDU,\n" +
                "\tunconfirmed-PDU\t\t\t[3] \tIMPLICIT Unconfirmed-PDU,\n" +
                "\trejectPDU\t\t\t\t[4] \tIMPLICIT RejectPDU,\n" +
                "\tcancel-RequestPDU\t\t[5] \tIMPLICIT Cancel-RequestPDU,\n" +
                "\tcancel-ResponsePDU\t\t[6] \tIMPLICIT Cancel-ResponsePDU,\n" +
                "\tcancel-ErrorPDU\t\t\t[7] \tIMPLICIT Cancel-ErrorPDU,\n" +
                "\tinitiate-RequestPDU\t\t[8] \tIMPLICIT Initiate-RequestPDU,\n" +
                "\tinitiate-ResponsePDU\t[9] \tIMPLICIT Initiate-ResponsePDU,\n" +
                "\tinitiate-ErrorPDU\t\t[10] \tIMPLICIT Initiate-ErrorPDU,\n" +
                "\tconclude-RequestPDU\t\t[11] \tIMPLICIT Conclude-RequestPDU,\n" +
                "\tconclude-ResponsePDU\t[12] \tIMPLICIT Conclude-ResponsePDU,\n" +
                "\tconclude-ErrorPDU\t\t[13] \tIMPLICIT Conclude-ErrorPDU\n" +
                "\t}");

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


