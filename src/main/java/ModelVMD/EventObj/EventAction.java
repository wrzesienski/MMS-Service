package ModelVMD.EventObj;

import MmsServices.BuildPointer;
import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

public class EventAction extends MmsObject {

    EventAction(String name){
        setObjName(name);
        setType(MmsObjectType.EVENT_ACTION);
    }

    EventAction(String name, String service){
        setObjName(name);
        setServiceReq(service);
        setType(MmsObjectType.EVENT_ACTION);
    }

    private String serviceReq;

    public String getServiceReq() {
        return serviceReq;
    }

    public void setServiceReq(String serviceReq) {
        this.serviceReq = serviceReq;
    }

    public void makeAction(String data){
        BuildPointer.makeRequest(serviceReq, data);
    }


    void defineEventAct(){};
    void deleteEventAct(){};
    void getEventActAttributes(){};
    void reportEventActStatus(){};


}
