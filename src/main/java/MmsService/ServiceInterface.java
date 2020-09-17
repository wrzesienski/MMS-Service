package MmsService;

import IecStructure.IED;

public interface ServiceInterface {

    String choice(int tag);

    String build(String data);

    String process(String data, IED ied);
}
