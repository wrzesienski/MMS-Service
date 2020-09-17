package res;

import IecStructure.IED;
import IecStructure.SclParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String str = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";

//        MmsClient mmsClient = new MmsClient();
        IED ied = new IED();
        SclParser.configSys(ied, str);
        ied.start();
//        mmsClient.start();




    }
}
