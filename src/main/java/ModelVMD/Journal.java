package ModelVMD;

public class Journal extends MmsObject {

    Journal(String name){
        setObjName(name);
        setType(MmsObjectType.JOURNAL);
    }

    void annotation(){}

    void data(){}

    void eventData(){}

    void readJournal(){}
    void writeJournal(){}
    void createJournal(){}
    void deleteJournal(){}
    void initializeJournal(){}


}
