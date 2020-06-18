package MmsService;

import ASN_1.BerNode;

public abstract class AbstractService extends BerNode implements ServiceInterface {

    private ServiceType service;
    private String data;

    public enum ServiceType {
        CHOICE,
        SEQUENCE
    }



    public ServiceType getService() {
        return service;
    }

    public void setService(ServiceType service) {
        this.service = service;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
