package MmsService.ResponceServices.VmdServices;

import MmsService.BuildPointer;
import MmsService.ServiceInterface;

public class GetNameListResponse implements ServiceInterface {
    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return BuildPointer.getParent(this, data);
    }

    @Override
    public String process(String data) {
        return null;
    }
}
