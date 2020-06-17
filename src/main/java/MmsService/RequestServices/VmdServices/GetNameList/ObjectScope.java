package MmsService.RequestServices.VmdServices.GetNameList;

import MmsService.AbstractService;
import ModelVMD.VMD;

/*
objectScope 		[1] CHOICE
		{
		vmdSpecific		[0] IMPLICIT NULL,
		domainSpecific		[1] IMPLICIT Identifier,
		aaSpecific		[2] IMPLICIT NULL
		},
 */

public class ObjectScope extends AbstractService {

    public ObjectScope(VMD vmd){setVmd(vmd);}

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return getVmd().getNameList().toString();
            case 1:
                return getVmd().getNameList(getData()).toString();
            default:
                return "Error";
        }
    }

    @Override
    public String build(String data) {
        return null;
    }

    @Override
    public String process(String data) {
        return null;
    }
}
