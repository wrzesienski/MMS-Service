package ModelVMD.EventObj;

public class EventCondition {

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
