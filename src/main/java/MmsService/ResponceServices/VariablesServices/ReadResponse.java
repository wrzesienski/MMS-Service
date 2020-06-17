package MmsService.ResponceServices.VariablesServices;

import MmsService.Pointer;
import MmsService.ServiceInterface;

public class ReadResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return Pointer.getParent(this.getClass().getSimpleName(), data);
    }

    @Override
    public String process(String data) {
        return null;
    }
}
