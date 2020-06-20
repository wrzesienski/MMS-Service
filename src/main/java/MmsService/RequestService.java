package MmsService;

public abstract class RequestService extends AbstractService{

    public RequestService(ServiceType serviceType){
        setService(serviceType);
    }

    @Override
    public String process(String data){
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
                String dataa = "";
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
                    dataa+=(choice(getId().getTag()));

                }
                return Pointer.getResponse(this, dataa);
            default:
                return null;
        }
    }
}
