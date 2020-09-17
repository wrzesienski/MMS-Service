package MmsService.ResponceServices.VariablesServices;

import MmsService.BuildPointer;
import MmsService.ServiceInterface;

public class WriteResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this.getClass().getSimpleName(), data);
    }

    @Override
    public String process(String data) {
        return null;
    }
}
