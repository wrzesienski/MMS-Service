package ModelVMD.EventObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;
import ModelVMD.VarAndTypeObj.MmsVar;

public class EventCondition extends MmsObject {

    EventCondition(){}

    EventCondition(String name){
        setObjName(name);
        setType(MmsObjectType.EVENT_CONDITION);
    }

    EventCondition(MmsVar monitVar, boolean deletable){
        monitoredVar = monitVar;

    }

    enum eventConStatus{
        IDLE, ACTIVE, DISABLED
    }

    eventConStatus state = eventConStatus.IDLE;
    boolean priority;
    boolean severity;

    private MmsVar monitoredVar;
    private boolean enabled = false;
    boolean alarmSumRep;
    boolean evaluationInterval;
    long timeLastActive;
    long timeLastIdle;

    public boolean isEnabled() {
        return enabled;
    }

    public void checkTrip(){
        if(true){
            enabled = true;
        }
    }

    public MmsVar getMonitoredVar() {
        return monitoredVar;
    }

    public void setMonitoredVar(MmsVar monitoredVar) {
        this.monitoredVar = monitoredVar;
    }
}
