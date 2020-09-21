package MmsServices.ResponceServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;

import java.util.ArrayList;

public class ReadJournalResponse extends HighStructServiceBody {
    public ReadJournalResponse() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        String[] ss = getData().split("##");
        for (String rep: ss){
            System.out.println(ss);
        }
        return null;
    }

    @Override
    public String build(String data) {
        ArrayList<String> str = new ArrayList<>();
        str.add(data);
        str.add("1");
        return ServiceConnector.getParent(this, CodeTypeConverter.s_dataToHex(str));
    }
}
