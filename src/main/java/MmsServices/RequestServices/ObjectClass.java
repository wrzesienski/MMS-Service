package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;

/*
		objectClass		[0] IMPLICIT INTEGER
			{
			nammedVariable		(0),
			scatteredAccess		(1),
			namedVariableList	(2),
			namedType		(3),
			semaphore		(4),
			eventCondition		(5),
			eventAction		(6),
			eventEnrollment		(7),
			journal			(8),
			domain			(9),
			programInvocation	(10),
			operatorStation		(11)
			}
 */

/**
 * service class finding dataNames
 */

public class ObjectClass extends HighStructServiceBody {

    public ObjectClass() {
        super(ServiceType.CHOICE);
    }

//    @Override
//    public String choice(int tag) {
//
//        switch (tag) {
//            case 0:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
//            case 1:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.OPERATOR_STATION));
//            case 2:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR_LIST));
//            case 3:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_TYPE));
//            case 4:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.SEMAPHORE));
//            case 5:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.EVENT_CONDITION));
//            case 6:
//                return null;
//            case 7:
//                return null;
//            case 8:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.JOURNAL));
//            case 9:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.DOMAIN));
//            case 10:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
//            case 11:
//                return CodeConverter.dataToHex(IDK.vmd.getNameList(MmsObjectType.NAMED_VAR));
//            default:
//                return null;
//        }
//    }

    @Override
    public String choice(int tag) {

        switch (tag) {
            case 0:
//                return CodeTypeConverter.dataToHex(getLD());
            case 1:
//                return CodeTypeConverter.dataToHex(getLN());
            case 2:
//                return CodeConverter.dataToHex(getDatSet());
            default:
                return null;
        }
    }

    @Override
    public String build(String data) {
        return CodeTypeConverter.stickMessage(data, CodeTypeConverter.stickId(0,0, 0));
    }


    /*
            nammedVariable		(0),
			scatteredAccess		(1),
			namedVariableList	(2),
			namedType		(3),
			semaphore		(4),
			eventCondition		(5),
			eventAction		(6),
			eventEnrollment		(7),
			journal			(8),
			domain			(9),
			programInvocation	(10),
			operatorStation		(11)
     */

//    private String scaleDataMean(){
//        String ret;
//
//        for (String str: getData().split(" ")){
//            if(!str.equals("")){
//                ret+=str.
//            }
//        }
//    }

//    private ArrayList<String> getDatSet(){
//        ArrayList<String> ob = new ArrayList<>();
//        for (LogicalDevice logicalDevice : getIed().getLogicalDevices()) {
//            for(LogicalNode logicalNode: logicalDevice.getLogicalNodeList()){
//            if (logicalNode.getRootName().equals(CodeTypeConverter.convertHexToString(getData().replaceAll(" ", "")))) {
//                ob.addAll(logicalNode.getMeasruments().keySet());
//            }}
//        }
//        return ob;
//    }
//private ArrayList<RootClass> getLD() {
//    return new ArrayList<>(getIed().getLogicalDevices());
//}
//
//    private ArrayList<RootClass> getLN() {
//        ArrayList<RootClass> ob = new ArrayList<>();
//        for (LogicalDevice logicalDevice : getIed().getLogicalDevices()) {
//            if (CodeTypeConverter.convertHexToString(getData().replaceAll(" ", "")).equals("1")){
//                ob.addAll(logicalDevice.getLogicalNodeList());
//                continue;
//            }
//            if (logicalDevice.getRootName().equals(CodeTypeConverter.convertHexToString(getData().replaceAll(" ", "")))) {
//                ob.addAll(logicalDevice.getLogicalNodeList());
//            }
//        }
//        return ob;
//    }

//    @Override
//    public String process(String data, IED ied) {
//        setContent(data);
//        return choice(getContent());
//    }
}
