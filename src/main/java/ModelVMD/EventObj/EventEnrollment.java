package ModelVMD.EventObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

public class EventEnrollment extends MmsObject {

    EventEnrollment(String name){
        setObjName(name);
        setType(MmsObjectType.EVENT_ENROLLMENT);
    }

    enum AlarmAcknowledgmentRules{
        NONE, SIMPLE, ACK_ACTIVE, ACK_ALL,
    }

    enum EnrollmentState{
        IDLE, ACTIVE, DISABLED
    }

    enum Transition{
        DISABLED_TO_ACTIVE,
        DISABLED_TO_IDLE,
        IDLE_TO_ACTIVE,
        IDLE_TO_DISABLED,
        ACTIVE_TO_IDLE,
        ACTIVE_TO_DISABLED,
        ANY_TO_DELETED
    }

    Transition transition;

    private EventAction eventAction;
    private EventCondition eventCondition;

    boolean notificLost;
    boolean clientApp;
    long duration;
    EnrollmentState actState;
    AlarmAcknowledgmentRules aar;
    long timeActAck;
    long timeIdleAck;

    public void scan(){
        if(eventCondition.isEnabled()){
            eventAction.makeAction(eventCondition.getMonitoredVar().getVarMean().toString());
        }
    }

    public EventAction getEventAction() {
        return eventAction;
    }
    public void setEventAction(EventAction eventAction) {
        this.eventAction = eventAction;
    }

    public EventCondition getEventCondition() {
        return eventCondition;
    }
    public void setEventCondition(EventCondition eventCondition) {
        this.eventCondition = eventCondition;
    }
}
