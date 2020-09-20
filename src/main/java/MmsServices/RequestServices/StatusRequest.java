package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import IedStructure.IED;
import MmsServices.ServiceConnector;
import MmsServices.ServiceInterface;

public class StatusRequest implements ServiceInterface {

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        String str = "";
        String[] splitData = CodeTypeConverter.convertIntArrayToHexByProt(data);
        for(int i = 0; i<splitData.length; i++){
            String id = CodeTypeConverter.stickId(0, 0, i);
            str += CodeTypeConverter.stickMessage(str, id);
        }

        return ServiceConnector.getParent(this.getClass().getSimpleName(), str);     }

    @Override
    public String process(String data, IED ied) {
//        data = CodeTypeConverter.s_dataToHex(IDK.vmd.status());
        return ServiceConnector.getResponse(this, data);
    }
}
