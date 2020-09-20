package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import IedStructure.RootClass;
import MmsServices.ServiceConnector;
import MmsServices.HighStructServiceBody;
import TerminalModel.NodeConnector;

import java.util.ArrayList;

/*
GetNameList-Request ::= SEQUENCE
	{
	objectClass		[0] IMPLICIT INTEGER,
	objectScope 		[1] CHOICE,
	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
	}
 */


public class GetNameListRequest extends HighStructServiceBody {

    public GetNameListRequest() {
        super(ServiceType.SEQUENCE);
    }

    public GetNameListRequest(String link) {
        super(ServiceType.SEQUENCE);
        setTextStructLink(link);
    }

    @Override
    public String choice(int tag) {

        switch (tag) {
            case 0:
                return CodeTypeConverter.s_dataToHex(getDatSet(tag));
            case 1:
                return CodeTypeConverter.s_dataToHex(getLP(tag));
            case 2:
//                return CodeConverter.dataToHex(getDatSet());
            default:
                return "Error 0";
        }
    }

    @Override
    public String build(String data) {

        // формат приема данных "data1 tag1 data2 tag2 "
        String[] split = data.split(" ");
        ArrayList<String> s = new ArrayList<>();
        for(int i=0;i<split.length; i+=2){
            s.add(split[i]);
            s.add(split[i+1]);
        }

        return ServiceConnector.getParent(this, CodeTypeConverter.s_dataToHex(s));
    }

    private ArrayList<String> getLP(int tag){
        ArrayList<String> ob = new ArrayList<>();
        RootClass root = getIed().getChild(CodeTypeConverter.convertHexToString(getData().replaceAll(" ", "")));
        for(RootClass ro: root.getChilds()){
            ob.add(ro.getRootName());
        }
        ob.add(String.valueOf(tag));
        return ob;
    }

    private ArrayList<String> getDatSet(int tag){
        NodeConnector con  =(NodeConnector) getIed().getChild(CodeTypeConverter.convertHexToString(getData().replaceAll(" ", "")));
        ArrayList<String> ob = new ArrayList<>(con.getMeasures().keySet());
        ob.add(String.valueOf(tag));
        return ob;
    }
}
