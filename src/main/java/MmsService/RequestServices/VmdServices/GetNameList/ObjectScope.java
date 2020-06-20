package MmsService.RequestServices.VmdServices.GetNameList;

import res.IDK;

/*
objectScope 		[1] CHOICE
		{
		vmdSpecific		[0] IMPLICIT NULL,
		domainSpecific		[1] IMPLICIT Identifier,
		aaSpecific		[2] IMPLICIT NULL
		},
 */

public class ObjectScope extends AbstractObjectChoice {

    @Override
    public String choice(int tag) {
        switch (tag) {
            case 0:
                return dataToHex(IDK.vmd.getNameList());
            case 1:
                return dataToHex(IDK.vmd.getNameList(getData()));
            default:
                return "Error";
        }
    }

    @Override
    public String build(String data) {
        return null;
    }
}
