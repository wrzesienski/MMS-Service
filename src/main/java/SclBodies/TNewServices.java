package SclBodies;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tNewServices", propOrder = {

})
public class TNewServices {

    @XmlElement(name = "Service")
    protected ArrayList<TS> services;



    public ArrayList<TS> getServices() {
        return services;
    }

    public void setServices(ArrayList<TS> services) {
        this.services = services;
    }


}
