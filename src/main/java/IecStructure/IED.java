package IecStructure;

import java.util.List;


/**
 * class of modeling ied body by iec61850 protocol
 */
public class IED extends RootClass{

    public IED(){setType(SclClass.IED);}

    private List<IedService> iedService;

    public List<IedService> getIedService() {
        return iedService;
    }

    public void setIedService(List<IedService> iedService) {
        this.iedService = iedService;
    }

    @Override
    public void stop() {

    }


}
