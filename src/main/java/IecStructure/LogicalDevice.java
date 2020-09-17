package IecStructure;

import java.util.ArrayList;
import java.util.List;

public class LogicalDevice {



    private ArrayList<String> reportAdresses;



    private IED ied;
    private String name;
    private List<LogicalNode> logicalNodeList;

    LogicalDevice(IED ied){
        this.ied = ied;
    }

    public List<LogicalNode> getLogicalNodeList() {
        return logicalNodeList;
    }

    public void setLogicalNodeList(List<LogicalNode> logicalNodeList) {
        this.logicalNodeList = logicalNodeList;
    }


    public ArrayList<String> getReportAdresses() {
        return reportAdresses;
    }

    public void setReportAdresses(ArrayList<String> reportAdresses) {
        this.reportAdresses = reportAdresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IED getIed() {
        return ied;
    }

    public void setIed(IED ied) {
        this.ied = ied;
    }

}

