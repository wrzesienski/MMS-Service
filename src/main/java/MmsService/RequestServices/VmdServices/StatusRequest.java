package MmsService.RequestServices.VmdServices;

import BerCoding.CodeConverter;
import MmsService.BuildPointer;
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
        String[] splitData = CodeConverter.convertIntArrayToHexByProt(data);
        for(int i = 0; i<splitData.length; i++){
            String id = CodeConverter.stickId(0, 0, i);
            str += CodeConverter.stickMessage(str, id);
        }

        return BuildPointer.getParent(this.getClass().getSimpleName(), str);     }

    @Override
    public String process(String data) {
        data = CodeConverter.s_dataToHex(IDK.vmd.status());
        return BuildPointer.getResponse(this, data);
    }
}
