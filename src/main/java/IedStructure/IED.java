package IedStructure;

import Connect.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * class of modeling ied body by iec61850 protocol
 */
public class IED extends RootClass{

    public IED(String sclLink, int id){
        setType(SclClass.IED);
        setSclLink(sclLink);
        setRootName("IED");
        setId(111); // default
    }


    private ArrayList<String> journal;

    private int id;
    private String sclLink;
    private Server server;
    private HashMap<Integer, Double> associations = new HashMap<>();
    private ArrayList<String> iedService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void deleteAssociations(int i){
        associations.remove(i);
    }

    public HashMap<Integer, Double> getAssociations() {
        return associations;
    }

    public void setAssociations(HashMap<Integer, Double> associations) {
        this.associations = associations;
    }

    public String getSclLink() {
        return sclLink;
    }

    public void setSclLink(String sclLink) {
        this.sclLink = sclLink;
    }

    public Server getServer() {
        return server;
    }



    public void setScadaServer(Server server) {
        this.server = server;
    }

    public String getJournal() {
        String ret = "";
        if(journal==null){
            journal=new ArrayList<>();
            return "";
        }

        for (String rep: journal){
            ret +=rep+"##";
        }

        return ret;
    }
    public void addToJournal(String report){
        if(this.journal==null){
            journal = new ArrayList<>();
        }
        journal.add(report);
    }

    public void addReport(String rep){
        if(journal ==null){
            setJournal(new ArrayList<String>());
        }
    }

    public void setJournal(ArrayList<String> journal) {
        this.journal = journal;
    }


    public ArrayList<String> getIedService() {
        return iedService;
    }

    public void setIedService(ArrayList<String> iedService) {
        this.iedService = iedService;
    }

    public void addIedService(String service){
        if(iedService==null){
            setIedService(new ArrayList<>());
        }
        iedService.add(service);
    }

    @Override
    public void start() throws IOException {
        for(RootClass child: getChilds()){
            if(child!=null) child.start();
        }
    }

    @Override
    public void stop() {

    }


}
