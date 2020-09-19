package MmsServices.RequestServices;

import MmsServices.HighStructServiceBody;

/*
Read-Request ::= SEQUENCE
	{
	specificationWithResult		[0] IMPLICIT BOOLEAN DEFAULT FALSE,
	variableAccessSpecificatn	[1] VariableAccessSpecification
	}
 */

public class GetDataValuesRequest extends HighStructServiceBody {


    public GetDataValuesRequest(){
        super(ServiceType.SEQUENCE);
    }

    public GetDataValuesRequest(String link) {
        super(ServiceType.SEQUENCE);
        setTextStructLink(link);
    }


    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
//                return CodeConverter.dataToHex(ooo());
            default:
                return "2";
        }
    }

//    public String ooo(){
//        // CAUSE RETURN VOID MEAN
//        String ret = "";
//        String[] str = getData().replaceAll(" ", "").split("$");
//        for(LogicalDevice ld: getIed().getLogicalDevices()){
//            if(ld.getRootName().equals(str[0])){
//                for(LogicalNode ln: ld.getLogicalNodeList()){
//                    if (ln.getRootName().equals(str[1])){
//                        ret+=ln.getMeasruments().get(str[2]).toString();
//                    }
//                }
//            }
//        }
//        return ret;
//    }

    @Override
    public String build(String data) {
        return null;
    }

}
