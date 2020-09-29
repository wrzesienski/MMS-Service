package IedStructure;

import TerminalModel.NodeConnector;

import java.io.IOException;
import java.util.ArrayList;

/**
 * класс формирования древовидной структуры модели IED
 */
public abstract  class RootClass implements ControlInterface{

    private String rootName;
    private SclClass type; // root type
    private ArrayList<RootClass> childs; // root childs
    private RootClass dad; // root dad

    public RootClass getDad() {
        return dad;
    }

    /**
     * method finds cousins by type
     * @param sclClass type
     * @return cousin
     */
    public RootClass getDadByType(SclClass sclClass){

            RootClass dad = getDad();
            if(dad == null) {return null;}
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

    public void addChildList(ArrayList<RootClass> childs) {
        if(getChildList()==null){
            setChildList(new ArrayList<>());
        }
        getChildList().addAll(childs);
    }

    public void addChild(RootClass child){
        if(getChildList()==null){
            setChildList(new ArrayList<>());
        }
        getChildList().add(child);
    }

    public void setChildList(ArrayList<RootClass> childs) {
        this.childs = childs;
    }

    public ArrayList<RootClass> getChildList(){
        return childs;
    }

    public ArrayList<RootClass> getChildListByType(SclClass clazz){
        ArrayList<RootClass> ret = new ArrayList<>();
        if(getChildList()==null){
            return null;
        }
        for(RootClass rt: getChildList()){
            if(rt.getType().equals(clazz)){
                ret.add(rt);
            }
            else {
                ArrayList<RootClass> r = getChildListByType(clazz);
                if(r!=null){ ret.addAll(r);
            }
        } return ret;

    }        return ret;
    }

    public RootClass getChildByName(String id){
        // id format "iedName$LdName$"
        if(getChildList()==null){
            return null;
        }

            for (RootClass rc: getChildList()) {
                if (rc.getRootName().equals(id)) {
                    return rc;
                } else {
                    RootClass ret = rc.getChildByName(id);
                    if (ret != null) return ret;

                }
            }
            // адрес не найден
            return null;
    }


    // костылевато
    public NodeConnector getNodeObj(){
        for(RootClass rootClass: getChildList()){
            if (rootClass.getType().equals(SclClass.LN_BODY)){
                return (NodeConnector) rootClass;
            }
        }
        return null;
    }

    @Override
    public void start() throws IOException {
        for(RootClass child: getChildList()){
            if(child!=null) child.start();
        }
    }
}
