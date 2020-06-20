package MmsService.RequestServices.VmdServices;

import BerCoding.Coder;
import MmsService.Pointer;
import MmsService.ServiceInterface;
import res.IDK;

public class StatusRequest implements ServiceInterface {

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        String str = "";
        String[] splitData = Coder.convertIntArrayToHexByProt(data);
        for(int i = 0; i<splitData.length; i++){
            String id = Coder.stickId(0, 0, i);
            str +=Coder.stickMessage(str, id);
        }

        return Pointer.getParent(this.getClass().getSimpleName(), str);     }

    @Override
    public String process(String data) {
        data = IDK.vmd.status();
        return Pointer.getResponse(this, data);
    }
}
