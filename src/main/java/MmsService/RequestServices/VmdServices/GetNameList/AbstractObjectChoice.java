package MmsService.RequestServices.VmdServices.GetNameList;

import BerCoding.CodeConverter;
import MmsService.AbstractService;

public abstract class AbstractObjectChoice extends AbstractService {

    @Override
    public String process(String data) {
        setData(data);
        String[] splitData = getData().split(" ", 3);
        setId(splitData[0]);
        setData(splitData[2].split(" ")[0]);
        return choice(Integer.parseInt(CodeConverter.convertHexToInt(getData())));
    }
}
