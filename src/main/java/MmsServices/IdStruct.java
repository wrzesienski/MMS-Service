package MmsServices;

/**
 * Id в структуре сообщения состоит из 3х частей:
 * - тип доступа сообщения;
 * - тип структуры сообщений;
 * - выбор сервиса;
 * В классе представлена структура Id сообщения
 */
public class IdStruct {

    private int type;
    private int struct;
    private int tag;

    public IdStruct(){
        type = 0;
        struct = 0;
        tag = 0;
    }

    public int getStruct() {
        return struct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setStruct(int struct) {
        this.struct = struct;
    }
}
