package MmsService;

import MmsService.RequestServices.ConfirmedRequest;
import MmsService.ResponceServices.ConfirmedResponse;
import MmsService.ResponceServices.VariablesServices.ReadResponse;
import MmsService.ResponceServices.VariablesServices.WriteResponse;
import MmsService.ResponceServices.VmdServices.GetNameListResponse;
import MmsService.ResponceServices.VmdServices.IdentifyResponse;
import MmsService.ResponceServices.VmdServices.StatusResponse;
import ModelVMD.VMD;

public class Pointer {

    public static String getResponse(String service, String data) {
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

    public static String getLength(String data){
        String[] splitData = data.split(" ");
        return Integer.toHexString(splitData.length);
    }

    /**
     * static method for pointing parent relations
     * @param service name of service
     * @param data building data
     * @return
     */
    public static String getParent(String service, String data){
        switch (service){
            case "ConfirmedRequest":
            case "ConfirmedResponse":
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
            case "IdentifyResponse":
            case "StatusResponse":
            case "ReadResponse":
            case "WriteResponse":
                return new ConfirmedResponse().build(data);

        }
        return "";
    }
}
