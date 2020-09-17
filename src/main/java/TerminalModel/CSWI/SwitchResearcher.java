package TerminalModel.CSWI;

import IecStructure.LogicalNode;
import TerminalModel.PDIS.MmsConnector;

import java.io.IOException;
import java.util.ArrayList;

public class SwitchResearcher extends MmsConnector {

    private boolean pos = true;
    private boolean orderOn = false;
    private boolean orderOff = false;

    public SwitchResearcher(LogicalNode logicalNode, ArrayList<String> meas){
        logicalNode.setMeasruments(takeCareOfMms(meas));
        setLogicalNode(logicalNode);

    }

    @Override
    public void start() throws IOException {
        Thread thread = new Thread(() -> {
            while (true) {
                pos = checkOrders();
            }
        });
        thread.start();
    }

    @Override
    public void setNewMeas() {
        String[] list = (String[]) getMeasures().keySet().toArray();
        for (int i = 0; i <= list.length; i++) {
            switch (list[i]) {
                case "Mod":
                    setMean(list[i], pos);
                    break;
                case "OpOpn":
                    setMean(list[i], orderOn);;
                    break;

                case "OpCls":
                    setMean(list[i], orderOff);
                    break;
            }
        }
    }

    private boolean checkOrders(){
        if (orderOn) {
            orderOn = false;
            return false;
        }
        if (orderOff){
            orderOff = false;
            return true;
        }
        return pos;
    }

    public boolean isPos() {
        return pos;
    }

    public void setPos(boolean pos) {
        this.pos = pos;
    }

    public boolean isOrderOn() {
        return orderOn;
    }

    public void setOrderOn(boolean orderOn) {
        this.orderOn = orderOn;
    }

}
