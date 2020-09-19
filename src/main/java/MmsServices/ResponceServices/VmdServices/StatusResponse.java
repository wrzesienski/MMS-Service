package MmsServices.ResponceServices.VmdServices;

import CodeProcessing.CodeTypeConverter;
import IecStructure.IED;
import MmsServices.AbstractService;
import MmsServices.BuildPointer;

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

public class StatusResponse extends AbstractService {


    @Override
    public String choice(int tag) {
        return null;
    }

    @Override
    public String build(String data) {

        String str = "";
        String[] splitData = CodeTypeConverter.convertIntArrayToHexByProt(data);
        for(int i = 0; i<splitData.length; i++){
            String id = CodeTypeConverter.stickId(0, 0, i);
            str += CodeTypeConverter.stickMessage(str, id);
        }

        return BuildPointer.getParent(this.getClass().getSimpleName(), str);
    }

    @Override
    public String process(String data, IED ied) {

        String[] splitData;
        splitData = data.split(" ", 4);
        setId(splitData[0]);
        setLength(splitData[1]);
        setContent(splitData[2]);
        if (getContent() == 1){
            splitData = splitData[3].split(" ", 3);
            setId(splitData[0]);
            setLength(splitData[1]);
            return choice(getId().getTag());
        }
        return "Error";    }
}
