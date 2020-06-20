package res;

import MmsService.MmsPDU;
import ModelVMD.MMSVar;
import ModelVMD.ProgControlObj.Domain;
import ModelVMD.VarAndTypeObj.NamedVar;
import ModelVMD.VmdStatus.VMD;

import java.util.ArrayList;
import java.util.Arrays;

public class IDK {

    public static NamedVar namedVar1 = new NamedVar("puk");
    public static NamedVar namedVar2 = new NamedVar("kek");
    public static ArrayList<MMSVar> list = new ArrayList<MMSVar>(Arrays.asList(namedVar1, namedVar2));
    public static Domain domain = new Domain("dom", list);

    public static VMD vmd = new VMD("", "", "",
            0 ,0, new ArrayList<Domain>(Arrays.asList(domain)));

    public static MmsPDU mmsPDU = new MmsPDU();

}
