package ModelVMD.EventObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

public class EventEnrollment extends MMSVar {

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
    boolean mmsDeletable;
    EventCondition eventCondition;
    boolean notificLost;
    EventAction eventAction;
    boolean clientApp;
    long duration;
    EnrollmentState actState;
    AlarmAcknowledgmentRules aar;
    long timeActAck;
    long timeIdleAck;


    void defineEventEnroll(){};
    void deleteEventEnroll(){};
    void getEventEnroll(){};
    void reportEventEnroll(){};
    void alterEventEnroll(){};

}
