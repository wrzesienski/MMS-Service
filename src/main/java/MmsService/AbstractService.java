package MmsService;

import ASN_1.BerNode;
import ModelVMD.VMD;

public abstract class AbstractService extends BerNode implements ServiceInterface {

    private ServiceType service;
    private String data;
    private VMD vmd;

    public VMD getVmd() {
        return vmd;
    }

    public void setVmd(VMD vmd) {
        this.vmd = vmd;
    }

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
