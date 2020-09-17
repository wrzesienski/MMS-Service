package TerminalModel.PDIS;

import IecStructure.LogicalNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class MmsConnector implements ConnectInterface {


    private LogicalNode logicalNode;

    @Override
    public void start() throws IOException {
    }
    public HashMap<String, Object> getMeasures() {
        return measures;
    }

    public void setMeasures(HashMap<String, Object> measures) {
        this.measures = measures;
    }

    private HashMap<String, Object> measures;

    @Override
    public void setNewMeas() {

    }

    public HashMap<String, Object> takeCareOfMms(List<String> list){
        measures = new HashMap<>();
        for (String str: list){
            measures.put(str, false);
        }
        return measures;
    }
    public void setMean(String str, Object obj){
        measures.replace(str, obj);
    }
    public void setMean(String str, Double obj){
        measures.replace(str, obj);
    }

    public void setMean(String str, Boolean obj){
        measures.replace(str, obj);
    }
    public void setMean(String str, Integer obj){
        measures.replace(str, obj);
    }

    public LogicalNode getLogicalNode() {
        return logicalNode;
    }

    public void setLogicalNode(LogicalNode logicalNode) {
        this.logicalNode = logicalNode;
    }

}
