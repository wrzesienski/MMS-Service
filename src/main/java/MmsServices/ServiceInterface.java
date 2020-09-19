package MmsServices;

import IecStructure.IED;

/**
 * базовый интерфейс сервисов MMS
 */
public interface ServiceInterface {

    /*
    метод выбора сервиса
     */
    String choice(int tag);

    /*
    метод построения request/responce сообщения соответствующего сервиса
     */
    String build(String data);

    /*
    обработка входящих декси-данных
     */
    String process(String data, IED ied);
}
