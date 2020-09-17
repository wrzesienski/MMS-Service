package MmsService;

import IecStructure.IED;

public abstract class RequestService extends AbstractService{

    public RequestService(ServiceType serviceType){
        setService(serviceType);
    }

    @Override
    public String process(String data, IED ied){
        setIed(ied);
        String[] splitData;
        setData(data);
        switch (getService()){
            case CHOICE:
                splitData = getData().split(" ", 3);
                setId(splitData[0]);
                setData(splitData[2]);
                return choice(getId().getTag());
            case SEQUENCE:
                boolean flag = true;
                StringBuilder dataa = new StringBuilder();
                while (flag){
                    splitData = data.split(" ", 3);
                    setId(splitData[0]);
                    setLength(splitData[1]);
                    setData(splitData[2]);
                    if(getLength()==splitData[2].split(" ").length) {
                        flag = false;
                    }
                    else{
                        String newData = "";
                        String[] newSplit = splitData[2].split(" ", getLength()+1);
                        for (int i = 0; i< getLength(); i++){
                            newData+=newSplit[i]+" ";
                        }
                        setData(newData);
                        data = newSplit[getLength()];
                    }
                    dataa.append(choice(getId().getTag()));

                }
                if (!data.isEmpty()) {
                    return BuildPointer.getResponse(this, dataa.toString());
                }
                return null;
            default:
                return null;
        }
    }
}
