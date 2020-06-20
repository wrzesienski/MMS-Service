package ModelVMD.ProgControlObj;

import ModelVMD.MMSVar;
import ModelVMD.MmsObjectType;

import java.util.ArrayList;

/**
 * Domains are to be viewed as containers which represent memory areas.
 * Domain contents can be interchanged between different devices.
 */
public class Domain extends MMSVar {

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
    String AAA; // Assigned Application Association
    boolean mmsDeletable; // указывает, может ли этот домен быть удален с помощью операции MMS.
    boolean sharable; // указывает, может ли домен использоваться более чем одним вызовом программы.


    ArrayList<String> domContentNameList;
    private ArrayList<MmsObjectType> domContent; // данные в домене
    private ArrayList<MMSVar> subObjList; // список объектов в домене

    // if IN_USE
    ArrayList<Object> progInvocRefsList;
    boolean uploadInProgress; // происходит ли подгрузка данных
//    String additDetail;

    public Domain(String name, ArrayList<MMSVar> list){
        setObjName(name);
        setType(MmsObjectType.DOMAIN);
        System.out.println(list.getClass().getSimpleName());
        subObjList = new ArrayList<>(list);
    }

    public ArrayList<MmsObjectType> getDomContent() {
        return domContent;
    }

    public void setDomContent(ArrayList<MmsObjectType> domContent) {
        this.domContent = domContent;
    }

    public ArrayList<MMSVar> getSubObjList() {
        return subObjList;
    }

    public void setSubObjList(ArrayList<MMSVar> subObjList) {
        this.subObjList = subObjList;
    }

    public ArrayList<String> getDomContentNameList() {
        return domContentNameList;
    }

    public void setDomContentNameList(ArrayList<String> domContentNameList) {
        this.domContentNameList = domContentNameList;
    }

}
