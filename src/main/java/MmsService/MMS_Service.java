package MmsService;

public class MMS_Service {

    /*
  confirmed-RequestPDU            [0]     IMPLICIT Confirmed-RequestPDU,
  confirmed-ResponsePDU           [1]     IMPLICIT Confirmed-ResponsePDU,
  confirmed-ErrorPDU              [2]     IMPLICIT Confirmed-ErrorPDU,
  unconfirmed-PDU                 [3]     IMPLICIT Unconfirmed-PDU,
  rejectPDU                       [4]     IMPLICIT RejectPDU,
  cancel-RequestPDU               [5]     IMPLICIT Cancel-RequestPDU,
  cancel-ResponsePDU              [6]     IMPLICIT Cancel-ResponsePDU,
  cancel-ErrorPDU                 [7]     IMPLICIT Cancel-ErrorPDU,
  initiate-RequestPDU             [8]     IMPLICIT Initiate-RequestPDU,
  initiate-ResponsePDU            [9]     IMPLICIT Initiate-ResponsePDU,
  initiate-ErrorPDU               [10]    IMPLICIT Initiate-ErrorPDU,
  conclude-RequestPDU             [11]    IMPLICIT Conclude-RequestPDU,
  conclude-ResponsePDU            [12]    IMPLICIT Conclude-ResponsePDU,
  conclude-ErrorPDU               [13]    IMPLICIT Conclude-ErrorPDU
     */

    public enum MMS_PDU{
        confirmedRequestPDU,
        confirmedResponsePDU,
        unconfirmedPDU,
        rejectPDU,
        cancelRequestPDU,
        cancelResponsePDU,
        cancelErrorPDU,
        initiateRequestPDU,
        initiateResponsePDU,
        initiateErrorPDU,
        concludeRequestPDU,
        concludeResponsePDU,
        concludeErrorPDU
    }

    Object choice(MMS_PDU choice){
        switch (choice){
            case rejectPDU:
                return null;
            case cancelErrorPDU:
                return null;
            case unconfirmedPDU:
                return null;
            case cancelRequestPDU:
                return null;
            case concludeErrorPDU:
                return null;
            case initiateErrorPDU:
                return null;
            case cancelResponsePDU:
                return null;
            case concludeRequestPDU:
                return null;
            case initiateRequestPDU:
                return null;
            case concludeResponsePDU:
                return null;
            case confirmedRequestPDU:
                return null;
            case initiateResponsePDU:
                return null;
            case confirmedResponsePDU:
                return null;
            default:
                return null;
        }
    }

}
