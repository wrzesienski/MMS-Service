package res;

import ModelVMD.MmsObject;
import ModelVMD.ProgControlObj.Domain;
import ModelVMD.VMD;
import ModelVMD.VarAndTypeObj.NamedVar;

import java.util.ArrayList;
import java.util.Arrays;

public class IDK {


    public static NamedVar namedVar1 = new NamedVar("puk");
    public static NamedVar namedVar2 = new NamedVar("kek");
    public static ArrayList<MmsObject> list = new ArrayList<MmsObject>(Arrays.asList(namedVar1, namedVar2));
    public static Domain domain = new Domain("dom", list);

    public static VMD vmd = new VMD("", "", "",
            0 ,0, new ArrayList<Domain>(Arrays.asList(domain)));

//    public static MmsPDU mmsPDU = new MmsPDU();

}
