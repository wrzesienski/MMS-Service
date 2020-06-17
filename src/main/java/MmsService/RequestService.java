package MmsService;

import ModelVMD.VMD;

public abstract class RequestService extends AbstractService{

    public RequestService(VMD vmd, ServiceType serviceType){
        setVmd(vmd);
        setService(serviceType);
    }

    @Override
    public String process(String data){
        String[] splitData;
        switch (getService()){
            case CHOICE:
                splitData = data.split(" ", 3);
                setId(splitData[0]);
                setData(splitData[2]);
                return choice(getId().getTag());
            case SEQUENCE:
                boolean flag = true;
                String dataa = "";
                while (flag){
                    splitData = data.split(" ", 3);
                    setId(splitData[0]);
                    setLength(splitData[1]);
                    dataa+=(choice(getId().getTag()));
                    if(getLength()==splitData[2].length()) {
                        flag = false;
                    }
                }
                return (dataa+(Pointer.getResponse(this.getClass().getSimpleName())));
            default:
                return null;
        }
    }
}
