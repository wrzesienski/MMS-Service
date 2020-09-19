package MmsServices.ResponceServices.VmdServices;

import MmsServices.ResponseService;

public class AccessResultResponce extends ResponseService {
    public AccessResultResponce() {
        super(ServiceType.CHOICE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                break; // failure
            case 1:
                return new AccessResultResponce().process(getData(), getIed());
        }
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
