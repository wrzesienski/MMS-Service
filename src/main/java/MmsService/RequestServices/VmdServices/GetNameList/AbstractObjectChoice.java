package MmsService.RequestServices.VmdServices.GetNameList;

import BerCoding.Coder;
import MmsService.AbstractService;
import ModelVMD.MMSVar;

import java.util.ArrayList;

public abstract class AbstractObjectChoice extends AbstractService {

    @Override
    public String process(String data) {
        setData(data);
        String[] splitData = getData().split(" ", 3);
        setId(splitData[0]);
        setData(splitData[2].split(" ")[0]);
        return choice(Integer.parseInt(Coder.convertHexToInt(getData())));
    }

    public String dataToHex(ArrayList<MMSVar> lisr){
        String ret = "";
        if(lisr.isEmpty()){
            ret+= Coder.convertStringToHex("null")+" ";
            ret = Coder.convertIntToHex(Integer.toString(ret.split(" ").length))
                    + " " + ret;
            ret =Coder.stickId(0, 0,0) + " " + ret;
        }else {
            for (MMSVar var : lisr) {
                ret += Coder.convertStringToHex(var.getObjName()) + " ";
                ret = Coder.convertIntToHex(Integer.toString(ret.split(" ").length))
                        + " " + ret;
                ret = Coder.stickId(0, 0, var.getType().getCode()) + " " + ret;

            }
        }
        return ret;

    }
}
