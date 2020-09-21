package TerminalModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface ConnectInterface {

    void start() throws IOException;

    public void rebuildMeasures();

    public void configData();

    public HashMap<String, Object> getMeasures();

    public HashMap<String, Object> addMeasures(List<String> list);

}
