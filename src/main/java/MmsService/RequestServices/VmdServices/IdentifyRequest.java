package MmsService.RequestServices.VmdServices;

import MmsService.Pointer;
import MmsService.ServiceInterface;

public class IdentifyRequest implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data) {
        return Pointer.getParent(this.getClass().getSimpleName(), data);
    }
}
