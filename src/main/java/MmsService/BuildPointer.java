package MmsService;

import BerCoding.CodeConverter;
import MmsService.RequestServices.ConfirmedRequest;
import MmsService.RequestServices.VariablesSevices.WriteRequest;
import MmsService.ResponceServices.ConfirmedResponse;
import MmsService.ResponceServices.VariablesServices.ReadResponse;
import MmsService.ResponceServices.VariablesServices.WriteResponse;
import MmsService.ResponceServices.VmdServices.GetNameListResponse;
import MmsService.ResponceServices.VmdServices.IdentifyResponse;
import MmsService.ResponceServices.VmdServices.StatusResponse;

public class BuildPointer {

    /**
     * method let's build response on service request
     * @param obj service
     * @param msg message
     * @return
     */
    public static String getResponse(Object obj, String msg) {
        String service = obj.getClass().getSimpleName();
        switch (service) {
            case "StatusRequest":
                return new StatusResponse().build(msg);
            case "IdentifyRequest":
                return new IdentifyResponse().build(msg);
            case "GetNameListRequest":
                return new GetNameListResponse().build(msg);
            case "WriteRequest":
                return new WriteResponse().build(msg);
            case "ReadRequest":
                return new ReadResponse().build(msg);
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
//                return new MmsPDU().build(msg);
            case "ConfirmedResponse":
                msg = addChoice(1, msg);
//                return new MmsPDU().build(msg);
            // request services
            case "GetNameListRequest":
            case "IdentifyRequest":
            case "RenameRequest":
            case "StatusRequest":
            case "ReadRequest":
            case "WriteRequest":
                return new ConfirmedRequest().build(msg);

            // response services
            case "GetNameListResponse":
                msg = addChoice(1, msg);
                return new ConfirmedResponse().build(msg);
            case "IdentifyResponse":
                msg = addChoice(2, msg);
                return new ConfirmedResponse().build(msg);
            case "StatusResponse":
                msg = addChoice(3, msg);
                return new ConfirmedResponse().build(msg);
            case "ReadResponse":
                msg = addChoice(4, msg);
                return new ConfirmedResponse().build(msg);
            case "WriteResponse":
                msg = addChoice(5, msg);
                return new ConfirmedResponse().build(msg);
        }
        return "";
    }

    private static String addChoice(int tag, String data){
        return CodeConverter.stickMessage(data, CodeConverter.stickId(1, 1, Integer.parseInt(Integer.toBinaryString(tag))));
    }

    public static void makeRequest(String service, String msg){
        switch (service){
            case "WriteRequest":
                new WriteRequest().build(msg);
                break;
        }
    }


}
