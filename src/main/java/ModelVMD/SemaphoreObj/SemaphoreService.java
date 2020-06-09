package ModelVMD.SemaphoreObj;

public interface SemaphoreService {

    void takeControl();
    void relinquishControl();
    void defineSemaphore();
    void deleteSemaphore();
    void reportSemaphoreStatus();
    void reportPoolSemaphoreStatus();
    void reportSemaphoreEntryStatus();
}
