package Connect;

import CodeProcessing.IedConfigurator;
import IecStructure.IED;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String str = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";
        IED ied = new IED();
        IedConfigurator.configIed(ied, str);
        ied.start();
    }
}
