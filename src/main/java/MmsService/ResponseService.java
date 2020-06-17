package MmsService;

public abstract class ResponseService extends AbstractService {

    @Override
    public String process(String data){
        String[] splitData;
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
