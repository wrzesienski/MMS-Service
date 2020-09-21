package Connect;

import IedStructure.IED;

import java.io.IOException;

public class IEDStarter {
    public static void main(String[] args) throws IOException {
        String str = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";
        new Server(new IED(str, 111));
    }
}
