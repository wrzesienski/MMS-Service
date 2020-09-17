package ModelVMD.ProgControlObj;

import ModelVMD.MmsObject;
import ModelVMD.MmsObjectType;

import java.util.ArrayList;

/**
 * Domains are to be viewed as containers which represent memory areas.
 * Domain contents can be interchanged between different devices.
 */
public class Domain extends MmsObject {

    public enum domState {
        LOADING,
        COMPLETE,
        INCOMPLETE,
        READY,
        IN_USE
    }

    public enum domService{
        InitiateDownloadSequence,
        DownloadSegment,
        TerminateDownloadSequence,

        InitiateUploadSequence,
        UploadSegment,
        TerminateUploadSequence,

        DeleteDomain,

        GetDomainAttributes,

        RequestDomainDownload,
        RequestDomainUpload,

        LoadDomainContent,
        StoreDomainContent
    }

    // if LOADING, COMPLETE, INCOMPLETE, READY
//    String AAA; // Assigned Application Association
//    boolean sharable; // указывает, может ли домен использоваться более чем одним вызовом программы.


    private ArrayList<String> domContentNameList;
//    private ArrayList<MmsObjectType> domContent; // данные в домене
    private ArrayList<MmsObject> subObjList; // список объектов в домене

    // if IN_USE
//    ArrayList<Object> progInvocRefsList; // список инвокаций, ссылающихся на домен
//    boolean uploadInProgress; // происходит ли подгрузка данных
//    String additDetail;

    public Domain(String name, ArrayList<MmsObject> list){
        setObjName(name);
        setType(MmsObjectType.DOMAIN);
        System.out.println(list.getClass().getSimpleName());
        subObjList = new ArrayList<>(list);
    }

    public ArrayList<MmsObject> getSubObjList() {
        return subObjList;
    }

    public void setSubObjList(ArrayList<MmsObject> subObjList) {
        this.subObjList = subObjList;
    }

    public ArrayList<String> getDomContentNameList() {
        return domContentNameList;
    }

    public void setDomContentNameList(ArrayList<String> domContentNameList) {
        this.domContentNameList = domContentNameList;
    }

}
