package MmsServices.RequestServices;

import MmsServices.HighStructServiceBody;

public class AssociationServiceRequest extends HighStructServiceBody {
    public AssociationServiceRequest() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
               assotiate();
               break;
            case 1:
                abort();
                break;
        };
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }

    public void assotiate(){ }

    public void abort(){}
}
