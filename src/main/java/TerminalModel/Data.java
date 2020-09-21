package TerminalModel;

public class Data{

    Data(){}
    Data(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Object mean;

    private Type type;

    public enum Type{
        ONLY_OPERATE,
        ONLY_READ,
        ALL
    }

    public Object getMean() {
        return mean;
    }

    public void setMean(Object mean) {
        this.mean = mean;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
