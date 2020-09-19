package MmsServices.RequestServices;

import IecStructure.IED;
import MmsServices.HighStructServiceBody;

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
//                ooo();
                break;
            default:
                return "2";
        }
        return null;
    }
//
//    public void ooo(){
//        String[] str = getData().replaceAll(" ", "").split("$");
//        for(LogicalDevice ld: getIed().getLogicalDevices()){
//            if(ld.getRootName().equals(str[0])){
//                for(LogicalNode ln: ld.getLogicalNodeList()){
//                    if (ln.getRootName().equals(str[1])){
//                        ln.getMeasruments().replace(str[2], str[3]);
//                    }
//                }
//            }
//        }
//    }

    @Override
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data, IED ied) {
        return null;
    }
}
