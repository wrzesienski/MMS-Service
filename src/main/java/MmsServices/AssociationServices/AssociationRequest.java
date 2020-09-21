package MmsServices.AssociationServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.ServiceConnector;
import MmsServices.HighStructServiceBody;

import java.util.ArrayList;
import java.util.HashMap;


/*
Initiate-RequestPDU ::= SEQUENCE
	{
	localDetailCalling	        		[0] IMPLICIT Integer32 OPTIONAL,
	proposedMaxServOutstandingCalling	[1] IMPLICIT Integer16,
	proposedMaxServOutstandingCalled	[2] IMPLICIT Integer16,
	proposedDataStructureNestingLevel	[3] IMPLICIT Integer8 OPTIONAL,
	mmsInitRequestDetail				[4] IMPLICIT InitRequestDetail
	}

InitRequestDetail ::= SEQUENCE
	{
	proposedVersionNumber			[0] IMPLICIT Integer16,
	proposedParameterCBB			[1] IMPLICIT ParameterSupportOptions,
	servicesSupportedCalling		[2] IMPLICIT ServiceSupportOptions
	}

 */

public class AssociationRequest extends HighStructServiceBody {


    public AssociationRequest() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {

        System.out.println("Initiate-RequestPDU ::= SEQUENCE\n" +
                "\t{\n" +
                "\tlocalDetailCalling\t        \t\t[0] IMPLICIT Integer32 OPTIONAL,\n" +
                "\tproposedMaxServOutstandingCalling\t[1] IMPLICIT Integer16,\n" +
                "\tproposedMaxServOutstandingCalled\t[2] IMPLICIT Integer16,\n" +
                "\tproposedDataStructureNestingLevel\t[3] IMPLICIT Integer8 OPTIONAL,\n" +
                "\tmmsInitRequestDetail\t\t\t\t[4] IMPLICIT InitRequestDetail\n\n" +
                "\t}");
        switch (tag) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:

                System.out.println(
                        "\tproposedMaxServOutstandingCalled\t[2] IMPLICIT Integer16,\n\n"
                );
                return setInitTime(tag);
            case 3:
                return null;
            case 4:
                System.out.println("\tmmsInitRequestDetail\t\t\t\t[4] IMPLICIT InitRequestDetail\n\n"
                );
                return getServices(tag);
            default:
                return null;
        }
    }

    private String setInitTime(int tag) {
        if (setAddress()) {
            ArrayList<String> retData = new ArrayList<>();
            retData.add(String.valueOf(Integer.parseInt(
                    CodeTypeConverter.convertHexToString(getData()).split("[$]")[0])));
            retData.add(String.valueOf(tag));
        }
        return "";
    }

    private String getServices(int tag) {

            String retServ = "";
            String[] clientServ =
                    CodeTypeConverter.convertHexToString(getData()).split("[$]");
            ArrayList<String> serverServices = getIed().getIedService();
            for (String clServ : clientServ) {
                for (String serServ : serverServices) {
                    if (clServ.equals(serServ)) {
                        retServ += serServ + "$";
                    }
                }
            }
            ArrayList<String> ret = new ArrayList<>();
            ret.add(retServ);
            ret.add("4");
            return CodeTypeConverter.s_dataToHex(ret);
    }

    public boolean setAddress() {
        HashMap<Integer, Double> associations = getIed().getAssociations();
        String dat = CodeTypeConverter.convertHexToString(getData());
        String[] dataa = dat.split("[$]");
        int id = Integer.parseInt(dataa[0]);
        double ass  =  Integer.parseInt(dataa[1]);
        if ((getIed().getAssociations().get(id) == null)) {
            associations.put(id, ass);
            return true;
        }
        return false;
    }

    @Override
    public String build(String data) {
        String[] a = data.split(" ");
        String InvokeId = a[1]+"$"+10000;
        ArrayList<String> ret1 = new ArrayList<>();
        ArrayList<String> ret2 = new ArrayList<>();
        ret1.add(InvokeId);
        ret1.add("2");
        String ss = CodeTypeConverter.s_dataToHex(ret1);
        ret2.add(a[0]);
        ret2.add("4");
        String ad = CodeTypeConverter.s_dataToHex(ret2);

        return ServiceConnector.getParent(this, (ss + ad).replaceAll("  ", " "));
    }
}
