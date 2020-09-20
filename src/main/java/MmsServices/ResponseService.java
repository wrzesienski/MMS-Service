package MmsServices;

import IedStructure.IED;

public abstract class ResponseService extends AbstractService {

    public ResponseService(ServiceType serviceType){setService(serviceType);}

    @Override
    public String process(String data, IED ied){
        setIed(ied);
        String[] splitData;
        setData(data);
        switch (getService()){
            case CHOICE:
                splitData = data.split(" ", 3);
                setId(splitData[0]);
                setData(splitData[2]);
                return null;
            case SEQUENCE:
                boolean flag = true;
                String dataa = "";
                while (flag){
                    splitData = data.split(" ", 3);
                    setId(splitData[0]);
                    setLength(splitData[1]);
                    setData(splitData[2]);
                    dataa+=(choice(getId().getTag()));
                    if(getLength()==splitData[2].length()) {
                        flag = false;
                    }
                }
                return null;
            default:
                return null;
        }
    }
}
