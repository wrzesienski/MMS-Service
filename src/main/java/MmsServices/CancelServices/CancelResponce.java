package MmsServices.CancelServices;

import MmsServices.HighStructServiceBody;

/*
Cancel-ResponsePDU ::= Unsigned32 	-- originalInvokeID

 */

public class CancelResponce extends HighStructServiceBody {
    public CancelResponce() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
