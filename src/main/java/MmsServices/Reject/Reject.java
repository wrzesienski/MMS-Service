package MmsServices.Reject;

import MmsServices.HighStructServiceBody;

public class Reject extends HighStructServiceBody {
    public Reject() {
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
