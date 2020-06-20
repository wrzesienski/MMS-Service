package MmsService;

import BerCoding.Coder;
import MmsService.RequestServices.ConfirmedRequest;
import MmsService.ResponceServices.ConfirmedResponse;
import MmsService.ResponceServices.VariablesServices.ReadResponse;
import MmsService.ResponceServices.VariablesServices.WriteResponse;
import MmsService.ResponceServices.VmdServices.GetNameListResponse;
import MmsService.ResponceServices.VmdServices.IdentifyResponse;
import MmsService.ResponceServices.VmdServices.StatusResponse;

public class Pointer {

    public static String getResponse(Object obj, String data) {
        String service = obj.getClass().getSimpleName();
        switch (service) {
            case "StatusRequest":
                return new StatusResponse().build(data);
            case "IdentifyRequest":
                return new IdentifyResponse().build(data);
            case "GetNameListRequest":
                return new GetNameListResponse().build(data);
            case "WriteRequest":
                return new WriteResponse().build(data);
            case "ReadRequest":
                return new ReadResponse().build(data);
            default:
                return null;
        }
    }

    /**
     * static method for pointing parent relations
     * @param obj service
     * @param data building data
     * @return
     */
    public static String getParent(Object obj, String data){
        String service = obj.getClass().getSimpleName();
        switch (service){
            case "ConfirmedRequest":
                // add InvokeId string
                data = addChoice(0, data);
                return new MmsPDU().build(data);
            case "ConfirmedResponse":
                data = addChoice(1, data);
                return new MmsPDU().build(data);
            // request services
            case "GetNameListRequest":
            case "IdentifyRequest":
            case "RenameRequest":
            case "StatusRequest":
            case "ReadRequest":
            case "WriteRequest":
                return new ConfirmedRequest().build(data);

            // response services
            case "GetNameListResponse":
                data = addChoice(1, data);
                return new ConfirmedResponse().build(data);
            case "IdentifyResponse":
                data = addChoice(2, data);
                return new ConfirmedResponse().build(data);
            case "StatusResponse":
                data = addChoice(3, data);
                return new ConfirmedResponse().build(data);
            case "ReadResponse":
                data = addChoice(4, data);
                return new ConfirmedResponse().build(data);
            case "WriteResponse":
                data = addChoice(5, data);
                return new ConfirmedResponse().build(data);
        }
        return "";
    }

    private static String addChoice(int tag, String data){
        return Coder.convertIntToHex(String.valueOf(tag)) + Coder.getLength(data) + data;
    }
}
