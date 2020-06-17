package ModelVMD.EventObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class EventCondition extends MMSVar {

    EventCondition(String name){
        setObjName(name);
        setType(MmsObjectType.EVENT_CONDITION);
    }

    enum eventConStatus{
        IDLE, ACTIVE, DISABLED
    }

    boolean mmsDeletable;
    eventConStatus state = eventConStatus.IDLE;
    boolean priority;
    boolean severity;
    Object monitoredVar;
    boolean enabled;
    boolean alarmSumRep;
    boolean evaluationInterval;
    long timeLastActive;
    long timeLastIdle;

    EventCondition(Object monitVar, boolean deletable){
        monitoredVar = monitVar;
        mmsDeletable = deletable;

    }

    void defineEventCon(){};
    void deleteEventCon(){};
    void getEventConAttributes(){};
    void reportEventConStatus(){};
    void AlterEventConMonitoring(){};
    void getAlarmSummary(){};
}
