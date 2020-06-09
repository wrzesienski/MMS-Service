package ModelVMD.ProgControlObj;

import ModelVMD.EventObj.EventAction;
import ModelVMD.EventObj.EventCondition;
import ModelVMD.EventObj.EventEnrollment;

import java.util.ArrayList;

public class ProgInvocation {

    String PIName;

    public enum PIService{
        CreatePI, DeletePI, Start, Stop, Resume, Reset, Kill, GetPIAttribute
    }

    public enum PIState{
        IDLE,
        STARTING,
        RUNNING,
        STOPPING,
        STOPPED,
        RESUMING,
        RESETTING,
        UNRUNNABLE
    }


    PIState actState; //описывает состояние, в котором может быть вызов программы.
    ArrayList<Domain> domList; /*
    содержит имена доменов, которые объединяются в вызов программы.
    Этот список также включает в себя такие домены, которые создаются самим вызовом программы
    (это может быть домен, в который записывается какой-либо вывод).*/
    boolean mmsDeletable;
    boolean reusable;
    boolean monitor; // указывает, сообщает ли программа-вызов о переходе к клиенту при выходе из состояния выполнения.

    // if monitor true
    EventAction EA_refs;
    EventCondition EC_refs;
    EventEnrollment EE_refs;

    String execArgument;
    String additDetail;
}
