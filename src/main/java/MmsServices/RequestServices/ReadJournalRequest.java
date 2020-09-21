package MmsServices.RequestServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.HighStructServiceBody;
import MmsServices.ServiceConnector;

import java.util.ArrayList;

public class ReadJournalRequest extends HighStructServiceBody {
    public ReadJournalRequest() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        return getIed().getJournal();
    }

    @Override
    public String build(String data) {
        ArrayList<String> journal = new ArrayList<>();
        journal.add("0");
        journal.add("1");
        return ServiceConnector.getParent(this, CodeTypeConverter.s_dataToHex(journal));
    }
}
