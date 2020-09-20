package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
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
        switch (tag){
            case 0:
//                return CodeConverter.dataToHex(ooo());
            case 1:
                return CodeTypeConverter.s_dataToHex(getValues(tag));
            default:
                return "2";
        }
    }

    public ArrayList<String> getValues(int tag){
        NodeConnector node = (NodeConnector) getIed().getChild(getData());
        ArrayList<String> ob = new ArrayList<>();
        for (Object str: node.getMeasures().entrySet()){
            ob.add(String.valueOf(str));
        }
        ob.add(String.valueOf(tag));
        return ob;
    }

    @Override
    public String build(String data) {
        return null;
    }

}
