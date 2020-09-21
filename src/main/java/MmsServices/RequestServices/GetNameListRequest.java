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
                return getLP(tag);
            case 1:
                return getDatSet(tag);
            case 2:
//                return CodeConverter.dataToHex(getDatSet());
            default:
                return "Error 0";
        }
    }

    @Override
    public String build(String data) {

        String ret = "";
        String[] da = data.split(" ");
        for(int i=0;i<da.length; i+=2){
            ArrayList<String> aa = new ArrayList<>();
            aa.add(da[i]);
            aa.add(da[i+1]);
            ret+=CodeTypeConverter.s_dataToHex(aa);
        }
        return ServiceConnector.getParent(this, ret.replaceAll("  ", " "));
    }

    private String getLP(int tag){
        ArrayList<String> ob = new ArrayList<>();
        String rootName = CodeTypeConverter.convertHexToString(getData().replaceAll(" ", ""));
        RootClass root = getIed().getChild(rootName);
        String ret= rootName+"##";
        for(RootClass ro: root.getChilds()){
            ret+=ro.getRootName()+"$";
        }
        ret+=" " + tag + " ";
        return ret;
    }

    private String getDatSet(int tag){
        String rootName = CodeTypeConverter.convertHexToString(getData().replaceAll(" ", ""));

        NodeConnector con  =(NodeConnector) getIed().getChild(rootName);
        ArrayList<String> ob = new ArrayList<>(con.getMeasures().keySet());
        String ret= rootName+"##";
        for (String key: ob){
            ret+=ob+"$";
        }
        ret+=" " + String.valueOf(tag)+ " ";
        return ret;
    }
}
