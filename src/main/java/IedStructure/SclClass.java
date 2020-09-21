package IedStructure;

public enum SclClass {
    IED(0),
    LD(1),
    LN(2),
    REPORT(3),
    LN_BODY(4),
    SCL(5);

    private int code;
    SclClass(int code){
        this.code = code;
    }
    public int getCode(){ return code;}

}
