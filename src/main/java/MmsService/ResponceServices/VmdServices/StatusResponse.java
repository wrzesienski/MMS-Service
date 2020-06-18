package MmsService.ResponceServices.VmdServices;

import MmsService.Pointer;
import MmsService.ServiceInterface;

/*
Status-Response ::= SEQUENCE {
    vmdLogicalStatus	     [0] IMPLICIT INTEGER {
      state-changes-allowed	  (0),
      no-state-changes-allowed	  (1),
      limited-services-allowed	  (2),
      support-services-allowed	  (3)
      },
    vmdPhysicalStatus	     [1] IMPLICIT INTEGER {
      operational		  (0),
      partially-operational	  (1),
      inoperable		  (2),
      needs-commissioning	  (3)
      },
    localDetail		     [2] IMPLICIT BIT STRING(SIZE(0..128)) OPTIONAL

    }
 */

public class StatusResponse implements ServiceInterface {


    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {

        String str = "";
        data = Coder

        return Pointer.getParent(this.getClass().getSimpleName(), data);
    }

    @Override
    public String process(String data) {
        return null;
    }
}
