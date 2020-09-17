package ModelVMD.ProgControlObj;

import ModelVMD.EventObj.EventCondition;
import ModelVMD.MmsObject;

import java.util.ArrayList;

public class ProgInvocation extends MmsObject {

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



    private ArrayList<Domain> domList; /*
    содержит имена доменов, которые объединяются в вызов программы.
    Этот список также включает в себя такие домены, которые создаются самим вызовом программы
    (это может быть домен, в который записывается какой-либо вывод).*/
    boolean mmsDeletable;
    boolean reusable;
    boolean monitor; // указывает, сообщает ли программа-вызов о переходе к клиенту при выходе из состояния выполнения.
    String execArgument;
    String additDetail;



    // if monitor true
//    EventAction EA_refs;
//    EventEnrollment EE_refs;
    private EventCondition EC_refs;

    boolean flag; // указывает на выход из потока

    ProgInvocation(){}

    ProgInvocation(String name){
        setObjName(name);
    }

    ProgInvocation(String name, ArrayList<Domain> domList, EventCondition eventCondition){
        setObjName(name);
        this.domList = domList;
        EC_refs = eventCondition;
    }

    void start(){
        flag = true;
        Thread tready = new Thread(() -> {
            while (flag) {

            }
        });
        tready.start();
    }

    void stop(){
        flag = false;
    }


    public ArrayList<Domain> getDomList() {
        return domList;
    }

    public Domain getByName(String name){
        for (Domain domain: domList){
            if(domain.getObjName().equals(name)){
                return domain;
            }
        }
        return null;
    }

    public void addDomain(Domain domain){
        domList.add(domain);
    }

    public void setDomList(ArrayList<Domain> domList) {
        this.domList = domList;
    }

    public EventCondition getEC_refs() {
        return EC_refs;
    }

    public void setEC_refs(EventCondition EC_refs) {
        this.EC_refs = EC_refs;
    }
}
