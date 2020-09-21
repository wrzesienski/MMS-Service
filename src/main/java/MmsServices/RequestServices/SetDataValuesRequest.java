package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;
import TerminalModel.NodeConnector;

import java.util.ArrayList;

public class SetDataValuesRequest extends HighStructServiceBody {


    public SetDataValuesRequest() {
        super(ServiceType.SEQUENCE);
    }

    public SetDataValuesRequest(String link) {
        super(ServiceType.SEQUENCE);
        setTextStructLink(link);
    }


    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                setValues();
                break;
            default:
                return "2";
        }
        return null;
    }

    @Override
    public String build(String data) {
        String ret = "";
        String[] da = data.split(" ");
        for(int i=0;i<=da.length; i+=2){
            ArrayList<String> aa = new ArrayList<>();
            aa.add(da[i]);
            aa.add("0");
            ret+= CodeTypeConverter.s_dataToHex(aa);
        }
        return ServiceConnector.getParent(this, ret.replaceAll("  ", " "));

    }

    public String setValues(){
        String[] aa = CodeTypeConverter.convertHexToString(getData()).split("##");
//        String[] bb = aa[1].split("[$]");
////        String[] cc = aa[2].split("[$]");
        NodeConnector node = (NodeConnector) getIed().getChild(aa[0]);
        if(node.getMeasMap().get(aa[1])!=null){
            node.setMean(aa[1],aa[2]);

        }
//        HashMap<String, Object> a = node.getMeasMap().get(aa[1]);
//        for(int i=0; i<bb.length; i++){
//            if(node.getMeasMap().get(bb[i])!=null) {
//                node.setMean(bb[i], cc[i]);
//            }  }
//        return null;
        return null;
    }
}
