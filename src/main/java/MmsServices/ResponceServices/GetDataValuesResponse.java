package MmsServices.ResponceServices;

import CodeProcessing.CodeTypeConverter;
import CodeProcessing.ConfigWorker;
import IedStructure.IED;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;
import SclBodies.SCL;

import java.util.ArrayList;

public class GetDataValuesResponse extends HighStructServiceBody {
    public GetDataValuesResponse() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        String[] d = getData().split("##");
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, getIed().getSclLink());

        return null;
    }

    @Override
    public String build(String data) {
        String ret = "";
        String[] da = data.split(" ");
        for(int i=0;i<da.length; i+=2){
            ArrayList<String> aa = new ArrayList<>();
            aa.add(da[i]);
            aa.add(da[i+1]);
            ret+= CodeTypeConverter.s_dataToHex(aa);
        }
        return ServiceConnector.getParent(this, ret.replaceAll("  ", " "));

    }

    @Override
    public String process(String data, IED ied) {
        return null;


    }
}
