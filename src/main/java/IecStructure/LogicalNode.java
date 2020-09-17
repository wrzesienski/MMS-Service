package IecStructure;

import TerminalModel.PDIS.MmsConnector;
import TerminalModel.ReportControl;

import java.util.HashMap;
import java.util.List;

public class LogicalNode {

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    private String nodeName;
    private LogicalDevice logicalDevice;
    LogicalNode(LogicalDevice logicalDevice){
        this.logicalDevice = logicalDevice;
    }

    private MmsConnector mm;
    private HashMap<String, Object> measruments;
    private List<ReportControl> reportControls;

    public MmsConnector getMm() {
        return mm;
    }

    public void setMm(MmsConnector mm) {
        this.mm = mm;
    }

    public List<ReportControl> getReportControls() {
        return reportControls;
    }

    public void setReportControls(List<ReportControl> reportControls) {
        this.reportControls = reportControls;
    }

    public HashMap<String, Object> getMeasruments() {
        return measruments;
    }

    public void setMeasruments(HashMap<String, Object> measruments) {
        this.measruments = measruments;
    }

    public LogicalDevice getLogicalDevice() {
        return logicalDevice;
    }

    public void setLogicalDevice(LogicalDevice logicalDevice) {
        this.logicalDevice = logicalDevice;
    }
}
