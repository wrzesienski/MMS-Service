package ModelVMD.ProgControlObj;

import java.util.ArrayList;

/**
 * Domains are to be viewed as containers which represent memory areas.
 * Domain contents can be interchanged between different devices.
 */
public class Domain {

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
    String domContent; // данные в домене
    ArrayList<Object> subObjList; // список объектов в домене

    // if IN_USE
    ArrayList<Object> progInvocRefsList;
    boolean uploadInProgress; // происходит ли подгрузка данных
    String additDetail;

    String domName;

}
