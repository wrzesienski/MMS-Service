package TerminalModel.CSWI;

import IedStructure.LogicalNode;
import IedStructure.SclClass;
import TerminalModel.Data;
import TerminalModel.NodeConnector;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  Switch manager service
 */
public class SwitchResearcher extends NodeConnector {

    private boolean pos = true;
    private boolean orderOn = false;
    private boolean orderOff = false;

    public SwitchResearcher(LogicalNode logicalNode, ArrayList<String> meas){
        super(logicalNode, meas);
        setType(SclClass.LN_BODY);

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
    public void stop() {

    }

    @Override
    public void rebuildMeasures() {
        for (Data d: getMes()) {
            switch (d.getName()) {
                case "Mod":
                    d.setMean(pos);
                    break;
                case "OpOpn":
                    orderOn = (Boolean) d.getMean();
                    break;
                case "OpCls":
                    orderOff = (Boolean) d.getMean();
                    break;
            }
        }
    }

    public void configData(){
        for(Data dat: getMes()){
            switch (dat.getName()){
                case "Mod":
                    dat.setType(Data.Type.ONLY_READ);
                    break;
                case "OpOpn":
                    dat.setType(Data.Type.ONLY_OPERATE);
                    dat.setMean(false);
                    break;
                case "OpCls":
                    dat.setType(Data.Type.ONLY_OPERATE);
                    dat.setMean(false);;
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
