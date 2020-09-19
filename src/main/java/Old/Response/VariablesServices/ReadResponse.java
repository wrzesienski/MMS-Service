package Old.Response.VariablesServices;

import IecStructure.IED;
import MmsServices.BuildPointer;
import MmsServices.ServiceInterface;

public class ReadResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this.getClass().getSimpleName(), data);
    }

    @Override
    public String process(String data, IED ied) {
        return null;
    }
}
