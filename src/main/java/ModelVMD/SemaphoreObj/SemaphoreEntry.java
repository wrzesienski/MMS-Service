package ModelVMD.SemaphoreObj;

public abstract class SemaphoreEntry {

    enum EntryState{
        QUEUED, OWNED, HUNG
    }

    boolean entryID;
    boolean namedToken;
    boolean appRefc;
    boolean priority;
    EntryState actState;
    boolean relinquishIfConLost;
    long controlTimeout;
    boolean abortOnTerminal;
    boolean acceptableDelay;

}
