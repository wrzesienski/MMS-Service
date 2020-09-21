package MmsServices.CancelServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.ServiceConnector;
import MmsServices.HighStructServiceBody;

import java.util.ArrayList;

/*
Cancel-RequestPDU ::= Unsigned32	-- originalInvokeID
 */

public class CancelRequest extends HighStructServiceBody {
    public CancelRequest() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {

        System.out.println("Cancel-RequestPDU ::= Unsigned32\t-- originalInvokeID\n");
        cancel();
        return null;
    }

    @Override
    public String build(String data) {
        ArrayList<String> l = new ArrayList<>();
        l.add(CodeTypeConverter.convertIntToHex(data));
        l.add("0");

        return ServiceConnector.getParent(this, CodeTypeConverter.s_dataToHex(l));
    }

    public void cancel(){
        int id = Integer.parseInt(getData());
        getIed().deleteAssociations(id);
    }
}
