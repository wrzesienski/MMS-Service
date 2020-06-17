package MmsService.ResponceServices;

import ASN_1.BerNode;
import MmsService.ResponseService;
import ModelVMD.VMD;

public class ConfirmedResponse extends ResponseService {

    VMD vmd;

    public ConfirmedResponse(VMD vmd){this.vmd = vmd;}

    public Object process(BerNode berNode) {
        return null;
    }

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }

    public String build(){

        return null;
    }
}
