package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;
import TerminalModel.NodeConnector;

import java.util.ArrayList;

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

        System.out.println("" +
                "Read-Request ::= SEQUENCE\n" +
                "\t{\n" +
                "\tspecificationWithResult\t\t[0] IMPLICIT BOOLEAN DEFAULT FALSE,\n" +
                "\tvariableAccessSpecificatn\t[1] VariableAccessSpecification\n" +
                "\t}");
        switch (tag){
            case 0:
//                return CodeConverter.dataToHex(ooo());
            case 1:
                return getValues(tag);
            default:
                return "2";
        }
    }

    public String getValues(int tag){
        String rootName = CodeTypeConverter.convertHexToString(getData());
        NodeConnector node = (NodeConnector) getIed().getChildByName(rootName);
        String ret =rootName+"##";
        for (Object str: node.getDataMeasuresHash().entrySet()){
            ret+=str+"$";
        }
        ret+=" " + tag + " ";
        return ret;
    }

    @Override
    public String build(String data) {
        String ret = "";
        String[] da = data.split(" ");
        for(int i=0;i<da.length; i+=2){
            ArrayList<String> aa = new ArrayList<>();
            aa.add(da[i]);
            aa.add("0");
            ret+=CodeTypeConverter.s_dataToHex(aa);
        }
        return ServiceConnector.getParent(this, ret.replaceAll("  ", " "));
    }

}
