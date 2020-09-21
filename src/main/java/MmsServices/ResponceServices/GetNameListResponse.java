package MmsServices.ResponceServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;

import java.util.ArrayList;


//GetNamedVariableListAttributes-Response ::= SEQUENCE
//        {
//        mmsDeletable		[0] IMPLICIT BOOLEAN,
//        AccessResultResponce		[1] IMPLICIT SEQUENCE OF SEQUENCE
//        {
//        [0] variableSpecification 		VariableSpecification,
//        alternateAccess			[5] IMPLICIT AlternateAccess OPTIONAL
//        }
//        }

public class GetNameListResponse extends HighStructServiceBody {
    public GetNameListResponse() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {

        System.out.println("GetNamedVariableListAttributes-Response ::= SEQUENCE\n" +
                "//        {\n" +
                "//        mmsDeletable\t\t[0] IMPLICIT BOOLEAN,\n" +
                "//        AccessResultResponce\t\t[1] IMPLICIT SEQUENCE OF SEQUENCE\n" +
                "//        {\n" +
                "//        [0] variableSpecification \t\tVariableSpecification,\n" +
                "//        alternateAccess\t\t\t[5] IMPLICIT AlternateAccess OPTIONAL\n\n" +
                "//        }");
        System.out.println(CodeTypeConverter.convertHexToString(getData()));
//        switch (tag){
//            case 0:
//                break;
//            case 1:
//                return new AccessResultResponce().process(getData(), getIed());
//        }
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
            ret+=CodeTypeConverter.s_dataToHex(aa);
        }
        return ServiceConnector.getParent(this, ret.replaceAll("  ", " "));
    }

}
