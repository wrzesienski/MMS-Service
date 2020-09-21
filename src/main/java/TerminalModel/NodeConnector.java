package TerminalModel;

import IedStructure.RootClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class NodeConnector extends RootClass implements ConnectInterface {

    public ArrayList<Data> getMes() {
        return mes;
    }
    public Data getNeededMes(String name){
        if(mes==null){
            return null;
        }
        for(Data d: mes){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;

    }

    public void addMes(String name){
        if(mes==null){
            mes= new ArrayList<>();
        }
        mes.add(new Data(name));
    }

    public void setMes(ArrayList<Data> mes) {
        this.mes = mes;
    }


    private ArrayList<Data> mes;
    private HashMap<String, Object> measures;

    public NodeConnector(RootClass dad, ArrayList<String> list){
        setDad(dad);

        for(String s: list){
            addMes(s);
        }
        configData();
        setRootName(dad.getRootName()+"$Engine");
    }


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
