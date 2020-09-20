package MmsServices.Error;

import CodeProcessing.CodeTypeConverter;
import IedStructure.IED;
import MmsServices.ServiceConnector;
import MmsServices.HighStructServiceBody;

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
        String dt = CodeTypeConverter.convertHexToInt(data);
        choice(Integer.parseInt(dt));
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);
    }

}
