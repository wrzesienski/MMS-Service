package MmsServices;

import IecStructure.IED;

/**
 * Класс сервисов запросов
 */
public abstract class HighStructServiceBody extends AbstractService{




    public HighStructServiceBody(ServiceType serviceType){
        setService(serviceType);
    }


    @Override
    public String process(String data, IED ied){
        setIed(ied);
        String[] levelSplitData;
        setData(data);
        StringBuilder returnedDataBuilder = new StringBuilder();
        String localRetData;
        // выбор алгоритма обработки в зависимости от типа сервиса
        switch (getService()){
            case CHOICE: // один параметр передаваемых данных
                /* делим данных для удобства обработки на
                   - id уровня данных;
                   - длину вкладки данных уровня данных;
                   - сама вкладка данных
                 */
                levelSplitData = getData().split(" ", 3);
                setId(levelSplitData[0]);
                setData(levelSplitData[2]);
                localRetData = choice(getId().getTag());
                if(localRetData!=null) {
                    returnedDataBuilder.append(localRetData);
                }
                break;
            case SEQUENCE: // ряд передаваемых данных
                boolean endOfMes = false;
                while (!endOfMes){
                    levelSplitData = data.split(" ", 3);
                    setId(levelSplitData[0]);
                    setLength(levelSplitData[1]);
                    setData(levelSplitData[2]);
                    /* сравниваем длину последовательности данных SEQUENCE
                     с общей длиной сообщения
                     смысл - узнать, есть ли на итерации обработки еще sequence
                     последовательности
                     */
                    if(getLength()==levelSplitData[2].split(" ").length) {
                        // дошли до конечной последовательности
                        endOfMes = true;
                    }
                    // если sequence не исчерпалась
                    else{
                        String localDataClaster = "";
                        /* по имеющемуся значению длины локального запроса в sequence потоке
                        через метод getLength отделяем кластер данных локального запроса и отправляем
                        его на обработку
                        по итогу разделения получаем сообщение вида: [l,o,c,a,l, otherData]
                         */
                        String[] localDataSplit = levelSplitData[2].split(" ", getLength()+1);
                        for (int i = 0; i< getLength(); i++){
                            // формируем кластер данных
                            localDataClaster+=localDataSplit[i]+" ";
                        }
                        setData(localDataClaster);
                        /* оставшиеся данных откладываем для новой итерации */
                        data = localDataSplit[getLength()];
                    }

                    localRetData = choice(getId().getTag());
                    if(localRetData!=null) {
                        // дополняем список данных для ответа клиенту
                        returnedDataBuilder.append(localRetData);
                    }

                }
                break;
            default:
                return null;
        }
        if (!(returnedDataBuilder.length()==0)) { // ???
            return BuildPointer.getResponse(this, returnedDataBuilder.toString());
        }
        return null;
    }
}
