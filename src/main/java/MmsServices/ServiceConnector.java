package MmsServices;

import CodeProcessing.CodeTypeConverter;
import MmsServices.AssociationServices.AssociationResponce;
import MmsServices.Error.AssociationError;
import MmsServices.Error.CancelError;
import MmsServices.Error.ConfirmedError;
import MmsServices.Error.UnconfirmedError;
import MmsServices.RequestServices.ConfirmedRequest;
import MmsServices.RequestServices.SetDataValuesRequest;
import MmsServices.ResponceServices.*;
import MmsServices.UnconfirmedServices.UncomfirmedService;

public class ServiceConnector {

    /**
     * method let's build response on service request
     * @param obj service
     * @param msg message
     * @return
     */
    public static String getResponse(Object obj, String msg) {
        String service = obj.getClass().getSimpleName();
        switch (service) {
            case "MmsPDU":
                return new MmsPDU().build(msg);
            case "StatusRequest":
                return new StatusResponse().build(msg);
            case "IdentifyRequest":
                return new IdentifyResponse().build(msg);
            case "GetNameListRequest":
                return new GetNameListResponse().build(msg);
            case "AssociationRequest":
                return new AssociationResponce().build(msg);
            case "GetDataValuesRequest":
                return new GetDataValuesResponse().build(msg);
            default:
                return null;
        }

    }

    /**
     * static method for pointing parent relations
     * @param obj service
     * @param msg building data
     * @return
     */
    public static String getParent(Object obj, String msg){
        String service = obj.getClass().getSimpleName();
        switch (service){
            case "ConfirmedRequest":
                // add InvokeId string
                msg = addChoice(0, msg);
                return new MmsPDU().build(msg);
            case "ConfirmedResponse":
                msg = addChoice(1, msg);
                return new MmsPDU().build(msg);

            case "AssociationRequest":
                msg = addChoice(8, msg);
                return new MmsPDU().build(msg);
            case "AssociationResponce":
                msg = addChoice(9,msg);
                return new MmsPDU().build(msg);
            // request services
            case "StatusRequest":
                msg = addChoice(0, msg);
                return new ConfirmedRequest().build(msg);

            case "CancelRequest":
                msg = addChoice(5, msg);
                return new MmsPDU().build(msg);
            case "GetNameListRequest":
                msg = addChoice(1, msg);
                return new ConfirmedRequest().build(msg);

            case "IdentifyRequest":
                msg = addChoice(2, msg);
                return new ConfirmedRequest().build(msg);
            case "RenameRequest":
                msg = addChoice(3, msg);
                return new ConfirmedRequest().build(msg);
            // response services
            case "GetNameListResponse":
                msg = addChoice(1, msg);
                return new ConfirmedResponse().build(msg);
            case "IdentifyResponse":
                msg = addChoice(2, msg);
                return new ConfirmedResponse().build(msg);
            case "GetDataValuesRequest":
                msg = addChoice(4, msg);
                return new ConfirmedRequest().build(msg);
            case "GetDataValuesResponse":
                msg = addChoice(3, msg);
                return new ConfirmedResponse().build(msg);
            case "ConfirmedError":
                msg = addChoice(2, msg);
                return new MmsPDU().build(msg);
            case "AssociationError":
                msg = addChoice(10, msg);
                return new MmsPDU().build(msg);
            case "CancelError":
                msg = addChoice(7, msg);
                return new MmsPDU().build(msg);
            case "UnconfirmedError":
                msg = addChoice(4, msg);
                return new MmsPDU().build(msg);
            case "EventNotification":
                msg = addChoice(2, msg);
                return new UncomfirmedService().build(msg);
            case "ReportInfo":
                msg = addChoice(0, msg);
                return new UncomfirmedService().build(msg);
            case "UncomfirmedService":
                msg = addChoice(3, msg);
                return new MmsPDU().build(msg);
            case "ReadJournalRequest":
                msg = addChoice(65, msg);
                return new MmsPDU().build(msg);
        }
        return "";
    }

    private static String addChoice(int tag, String data){
        return CodeTypeConverter.stickMessage(data, CodeTypeConverter.stickId(1, 1, Integer.parseInt(Integer.toBinaryString(tag))));
    }

    public static void makeRequest(String service, String msg){
        switch (service){
            case "WriteRequest":
                new SetDataValuesRequest().build(msg);
                break;
        }
    }

    public static String getError(Object obj, String msg){
        String service = obj.getClass().getSimpleName();
        switch (service){
            case "ConfirmedRequest":
            case "GetNameListRequest":
            case "GetDataValuesRequest":
            case "SetDataValuesRequest":
            case "IdentifyRequest":

            case "RenameRequest":

            case "ReadRequest":

            case "WriteRequest":

            case "WriteResponse":
            case "ReadResponse":
            case "StatusResponse":
            case "IdentifyResponse":

                // response services
            case "GetNameListResponse":
            case "ConfirmedResponse":
                // request services
                return new ConfirmedError().build(msg);

            case "StatusRequest":
            case "EventNotification":
                return new UnconfirmedError().build(msg);
            case  "AssociationRequest":
            case  "AssociationResponce":
                return new AssociationError().build(msg);
            case "CancelRequest":
            case "CancelResponce":
                return new CancelError().build(msg);

        }
        return "";
    }


}
