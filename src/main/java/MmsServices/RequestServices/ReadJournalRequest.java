package MmsServices.RequestServices;

import MmsServices.HighStructServiceBody;

public class ReadJournalRequest extends HighStructServiceBody {
    public ReadJournalRequest() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
