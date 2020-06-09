package ModelVMD.EventObj;

public class EventCondition {

    enum eventConStatus{
        IDLE, ACTIVE, DISABLED
    }

    boolean mmsDeletable;
    eventConStatus state;
    boolean priority;
    boolean severity;
    boolean monitoredVar;
    boolean enabled;
    boolean alarmSumRep;
    boolean evaluationInterval;
    long timeLastActive;
    long timeLastIdle;

    void defineEventCon(){};
    void deleteEventCon(){};
    void getEventConAttributes(){};
    void reportEventConStatus(){};
    void AlterEventConMonitoring(){};
    void getAlarmSummary(){};
}
