package IedStructure;

import java.util.ArrayList;

public class LogicalDevice extends RootClass{



    private ArrayList<String> reportAdresses;

    public LogicalDevice(IED ied){
        setType(SclClass.LD);
        setDad(ied);
    }

    public ArrayList<String> getReportAdresses() {
        return reportAdresses;
    }

    public void setReportAdresses(ArrayList<String> reportAdresses) {
        this.reportAdresses = reportAdresses;
    }

    @Override
    public void stop() {

    }
}

