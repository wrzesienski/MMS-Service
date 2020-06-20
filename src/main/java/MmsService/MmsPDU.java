package MmsService;

import MmsService.RequestServices.ConfirmedRequest;
import MmsService.ResponceServices.ConfirmedResponse;

public class MmsPDU extends RequestService {

    public MmsPDU(){
        super(ServiceType.CHOICE);
    }


    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                return new ConfirmedRequest().process(getData());
            case 1:
                return new ConfirmedResponse().process(getData());
            default: // add Error
                return "Error";
        }    }

    @Override
    public String build(String data) {
        return data;
    }

}


