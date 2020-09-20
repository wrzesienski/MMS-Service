package TerminalModel;

import IedStructure.RootClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class NodeConnector extends RootClass implements ConnectInterface {


    public NodeConnector(RootClass dad, ArrayList<String> list){
        setDad(dad);
        addMeasures(list);
        setRootName(dad.getRootName()+"_Engine");
    }

    private HashMap<String, Object> measures;

    @Override
    public HashMap<String, Object> getMeasures() {
        return measures;
    }


    @Override
    public void rebuildMeasures() {

    }

    @Override
    public HashMap<String, Object> addMeasures(List<String> list) {
        if(getMeasures()==null) {
            measures = new HashMap<>();
        }
        for (String str : list) {
            measures.put(str, false);
        }
        return measures;
    }

    public void setMean(String str, Object obj) {
        measures.replace(str, obj);
    }

    public void setMean(String str, Double obj) {
        measures.replace(str, obj);
    }

    public void setMean(String str, Boolean obj) {
        measures.replace(str, obj);
    }

    public void setMean(String str, Integer obj) {
        measures.replace(str, obj);
    }


}
