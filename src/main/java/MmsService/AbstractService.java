package MmsService;

import ASN_1.BerNode;
import IecStructure.IED;


public abstract class AbstractService extends BerNode implements ServiceInterface {

    public IED getIed() {
        return ied;
    }

    public void setIed(IED ied) {
        this.ied = ied;
    }

    private IED ied;
    private ServiceType service;
    private String data; // in octets

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
