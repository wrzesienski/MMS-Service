package IedStructure;

import TerminalModel.NodeConnector;

import java.io.IOException;
import java.util.ArrayList;

public abstract  class RootClass implements ControlInterface{

    private String rootName;
    private SclClass type;

    private ArrayList<RootClass> childs;
    private RootClass dad;

    public RootClass getDad() {
        return dad;
    }

    public RootClass getDadByType(SclClass sclClass){
        boolean flag = true;

            RootClass dad = getDad();
            if(dad.equals(null)) {return null;}
            if (dad.getType()==sclClass){
                return dad;
            }
            else {
                return dad.getDadByType(sclClass);
            }
    }

    public void setDad(RootClass dad) {
        this.dad = dad;
    }

    public SclClass getType() {
        return type;
    }

    public void setType(SclClass type) {
        this.type = type;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public void addChilds(ArrayList<RootClass> childs) {
        if(getChilds()==null){
            setChilds(new ArrayList<>());
        }
        getChilds().addAll(childs);
    }

    public void addChild(RootClass child){
        if(getChilds()==null){
            setChilds(new ArrayList<>());
        }

        getChilds().add(child);
    }

    public void setChilds(ArrayList<RootClass> childs) {
        this.childs = childs;
    }

    public ArrayList<RootClass> getChilds(){
        return childs;
    }

    public RootClass getChild(String id){
        // id format "iedName$LdName$"
        if(getChilds()==null){
            return null;
        }

            for (RootClass rc: getChilds()) {
                if (rc.getRootName().equals(id)) {
                    return rc;
                } else {
                    RootClass ret = rc.getChild(id);
                    if (ret != null) return ret;

                }
            }
            // адрес не найден
            return null;
    }

    public NodeConnector getNodeObj(){
        for(RootClass rootClass: getChilds()){
            if (rootClass.getType().equals(SclClass.LN_BODY)){
                return (NodeConnector) rootClass;
            }
        }
        return null;
    }

    @Override
    public void start() throws IOException {
        for(RootClass child: getChilds()){
            if(child!=null) child.start();
        }
    }
}
