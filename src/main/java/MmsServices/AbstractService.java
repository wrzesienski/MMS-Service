package MmsServices;

import IedStructure.IED;

/**
 *  Класс абстрактного сервиса MMS
 */
public abstract class AbstractService extends ASN1Body implements ServiceInterface {



    private String textStructLink;
    private IED ied; // ied, с которым работает сервис
    private ServiceType service; // принцип обработки данных сервиса
    private String data; // in octets

    public enum ServiceType {
        CHOICE, // структура данных в виде единократного выбора
        SEQUENCE // структура данных в виде последовательностей выбора
    }

    public String getTextStructLink() {
        return textStructLink;
    }

    public void setTextStructLink(String textStructLink) {
        this.textStructLink = textStructLink;
    }

    public ServiceType getService() {
        return service;
    }

    public void setService(ServiceType service) {
        this.service = service;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public IED getIed() {
        return ied;
    }

    public void setIed(IED ied) {
        this.ied = ied;
    }
}
