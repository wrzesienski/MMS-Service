package MmsServices;

import IedStructure.IED;

public abstract class DownStructServiceBody extends AbstractService {

    @Override
    public String process(String data, IED ied) {
        setIed(ied);
        setData(data);
        String[] splitData = getData().split(" ", 3);
        setId(splitData[0]);
//        setData(splitData[2].split(" ")[0]); // избавляемся от лишнего
        setData(splitData[2]); // избавляемся от лишнего
        return choice(getId().getTag());
    }
}
