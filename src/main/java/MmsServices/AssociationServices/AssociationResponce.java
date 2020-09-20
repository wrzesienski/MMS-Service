package MmsServices.AssociationServices;

import CodeProcessing.CodeTypeConverter;
import CodeProcessing.ConfigWorker;
import IedStructure.IED;
import MmsServices.ServiceConnector;
import MmsServices.HighStructServiceBody;
import SclBodies.SCL;
import SclBodies.TS;

import java.util.ArrayList;

/*
Initiate-ResponsePDU ::= SEQUENCE
	{
	localDetailCalled					[0] IMPLICIT Integer32 OPTIONAL,
	negociatedMaxServOutstandingCalling	[1] IMPLICIT Integer16,
	negociatedMaxServOutstandingCalled	[2] IMPLICIT Integer16,
	negociatedDataStructureNestingLevel	[3] IMPLICIT Integer8 OPTIONAL,
	mmsInitResponseDetail			[4] IMPLICIT InitResponseDetail
	}

InitResponseDetail ::= SEQUENCE
	{
	negociatedVersionNumber			[0] IMPLICIT Integer16,
	negociatedParameterCBB			[1] IMPLICIT ParameterSupportOptions,
	servicesSupportedCalled			[2] IMPLICIT ServiceSupportOptions
	}
 */

public class AssociationResponce extends HighStructServiceBody {
    public AssociationResponce() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                setServices();
                break;

            default:
                break;
        }
        return null;
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);    };


    public void setServices(){
        String[] clientServ =
                CodeTypeConverter.convertHexToString(getData()).split("[$]");
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, getIed().getSclLink());
        ArrayList<TS> ts = new ArrayList<>();
        for (String serv: clientServ){
            TS tss = new TS();
            tss.setSs(serv);
            ts.add(tss);
        }
        scl.getIED().get(0).getServices().setServices(ts);
        ConfigWorker.marshalAny(SCL.class, scl, getIed().getSclLink());
    }

    @Override
    public String process(String data, IED ied) {
        setIed(ied);
        String[] splitData;
        splitData = data.split(" ", 3);
        setId(splitData[0]);
        setLength(splitData[1]);
        setData(splitData[2]);
        return choice(getId().getTag());

    }
}
