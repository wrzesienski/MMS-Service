package MmsServices.Error;

import IedStructure.IED;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;

public abstract class Error extends HighStructServiceBody {
    public Error() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String process(String data, IED ied) {
        setIed(ied);
        String[] splitData = data.split(" ", 3);
        setId(splitData[0]);
        getReason(getData());
        return null;
    }

    public void getReason(String data){
        System.out.println(data);
//        String dt = CodeTypeConverter.convertHexToInt(data);
//        choice(Integer.parseInt(dt));
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);
    }

}
