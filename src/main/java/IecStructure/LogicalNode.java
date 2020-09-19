package IecStructure;

public class LogicalNode extends RootClass{

    public LogicalNode(LogicalDevice logicalDevice){
        setType(SclClass.LN);
        setDad(logicalDevice);
    }
    
    @Override
    public void stop() {

    }
}
