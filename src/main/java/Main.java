import Connect.MmsClient;
import Connect.MmsServer;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        MmsClient mmsClient = new MmsClient();
        MmsServer mmsServer = new MmsServer();

        mmsServer.start();
        mmsClient.start();

    }
}
