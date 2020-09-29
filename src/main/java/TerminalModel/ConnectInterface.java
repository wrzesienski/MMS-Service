package TerminalModel;

import java.io.IOException;

public interface ConnectInterface {

    void start() throws IOException;


    /**
     * method of rebuilding actual measures from a root
     */
    public void rebuildMeasures();

    public void configData();


}
