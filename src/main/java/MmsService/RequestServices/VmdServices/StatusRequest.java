package MmsService.RequestServices.VmdServices;

import MmsService.Pointer;
import MmsService.ServiceInterface;
import res.IDK;

public class StatusRequest implements ServiceInterface {

    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {
        return Pointer.getParent(this, data);
    }

    @Override
    public String process(String data) {
        data = IDK.vmd.status();
        return Pointer.getResponse(this, data);
    }
}
