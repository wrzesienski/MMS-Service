package ModelVMD;

public interface StructInterface {

    /**
     * This method is used to obtain the value of a specified object
     * @return
     */
    Object get(String objName);

    /**
     * This method is used to write/put value or contents into a
     * specified object
     */
    void set(Object someObj, String objName);

    /**
     * This method is used to write/put value or contents into a
     * specified object.
     */
    Object[] getQueryAttributes();

    /**
     * This method allows objects of particular classes to be
     * instantiated.
     */
    void create(Object obj, String objName);

    /**
     * This method allows instantiated objects to be renamed.
     */
    void rename(String oldName, String newName);

    /**
     * This method allows instantiated objects to be destroyed.
     */
    void destroy(String objName);





}
