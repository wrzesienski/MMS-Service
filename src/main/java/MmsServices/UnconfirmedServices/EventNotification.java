package MmsServices.UnconfirmedServices;

import CodeProcessing.CodeTypeConverter;
import IedStructure.IED;
import MmsServices.LowStructServiceBody;
import MmsServices.ServiceConnector;
import java.util.ArrayList;

public class EventNotification extends LowStructServiceBody {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        ArrayList<String> l = new ArrayList<>();
        l.add(data);
        l.add("0");
        return ServiceConnector.getParent(this, CodeTypeConverter.s_dataToHex(l));
    }

    @Override
    public String process(String data, IED ied) {
        setIed(ied);
        String[] splitData = data.split(" ", 3);
        setId(splitData[0]);
        setData(splitData[2]);
        System.out.println(CodeTypeConverter.convertHexToString(getData()));
        return null;
    }
}
