package MmsServices.ResponceServices.VmdServices;

import MmsServices.ResponseService;

public class DataResponce extends ResponseService {

    public DataResponce() {
        super(ServiceType.SEQUENCE);
    }

    @Override
    public String choice(int tag) {
        switch (tag){
            case 0:
                break; // boolean
            case 1:
                break; // integer
        }
        return null;
    }

    @Override
    public String build(String data) {
        return null;
    }
}
