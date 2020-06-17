package MmsService;

import MmsService.RequestServices.ConfirmedRequest;
import MmsService.ResponceServices.ConfirmedResponse;
import ModelVMD.VMD;

public class MmsPDU extends RequestService {

    public MmsPDU(VMD vmd){
        super(vmd, ServiceType.CHOICE);
    }


    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                return new ConfirmedRequest(getVmd()).process(getData());
            case 1:
                return new ConfirmedResponse(getVmd()).process(getData());
            default: // add Error
                return "Error";
        }    }

    @Override
    public String build(String data) {
        return null;
    }

}


