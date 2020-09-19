package MmsServices.ResponceServices.VmdServices;

import IecStructure.IED;
import MmsServices.BuildPointer;
import MmsServices.ServiceInterface;

public class IdentifyResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this, data);
    }

    @Override
    public String process(String data, IED ied) {
        return null;
    }
}
