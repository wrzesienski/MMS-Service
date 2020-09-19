package IecStructure;

public enum SclClass {
    IED(0),
    LD(1),
    LN(2),
    REPORT(3),
    LN_BODY(4);

    private int code;
    SclClass(int code){
        this.code = code;
    }
    public int getCode(){ return code;}

}
