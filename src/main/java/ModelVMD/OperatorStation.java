package ModelVMD;

public class OperatorStation extends MmsObject {
    // 3 types of OS: entry, display, entry-display

    OperatorStation(String name){
        setObjName(name);
        setType(MmsObjectType.OPERATOR_STATION);
    }

    void input(){};
    void output(){};

}
