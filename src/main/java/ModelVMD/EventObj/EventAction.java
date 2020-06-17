package ModelVMD.EventObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class EventAction extends MMSVar {

    EventAction(String name){
        setObjName(name);
        setType(MmsObjectType.EVENT_ACTION);
    }

    boolean mmsDeletable;
    boolean serviceReq;

    void defineEventAct(){};
    void deleteEventAct(){};
    void getEventActAttributes(){};
    void reportEventActStatus(){};


}
