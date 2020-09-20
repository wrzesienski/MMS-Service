package MmsServices.ResponceServices.VmdServices;

import IedStructure.IED;
import MmsServices.ServiceConnector;
import MmsServices.ServiceInterface;

public class IdentifyResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return ServiceConnector.getParent(this, data);
    }

    @Override
    public String process(String data, IED ied) {
        return null;
    }
}
