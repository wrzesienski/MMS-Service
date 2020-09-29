package TerminalModel;

import IedStructure.RootClass;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class NodeConnector extends RootClass implements ConnectInterface {

    private ArrayList<Data> measures;

    public NodeConnector(RootClass dad, ArrayList<String> list){
        setDad(dad);

        for(String s: list){
            addMeasuringData(s);
        }
        configData();
        setRootName(dad.getRootName()+"$Engine");
    }


    public ArrayList<Data> getMeasuresList() {
        return measures;
    }


    public Data getDataByName(String name){
        if(measures ==null){
            return null;
        }
        for(Data d: measures){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;

    }

    public void addMeasuringData(String name){
        if(measures ==null){
            measures = new ArrayList<>();
        }
        measures.add(new Data(name));
    }

    public void setMeasureList(ArrayList<Data> mes) {
        this.measures = mes;
    }

    public ArrayList<String> getDataNameList(){
        ArrayList<String> ret = new ArrayList<>();
        for(Data str: measures){
            ret.add(str.getName());
        }
        return ret;
    }

    public HashMap<String, Object> getDataMeasuresHash(){
        HashMap<String, Object> ret = new HashMap<>();
        for(Data d: getMeasuresList()){
            ret.put(d.getName(), d.getMean());
        }
        return ret;
    }


    @Override
    public void rebuildMeasures() {

    }

    public void setMean(String str, Object obj) {
        for (Data d: getMeasuresList()){
            if(d.getName().equals(str)){
                d.setMean(obj);
                break;
            }
        }
    }


}
