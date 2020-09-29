package TerminalModel.CSWI;

import IedStructure.LogicalNode;
import IedStructure.SclClass;
import TerminalModel.Data;
import TerminalModel.NodeConnector;

import java.util.ArrayList;

/**
 *  Switch manager service
 */
public class CSWI extends NodeConnector {

    private boolean pos = true; // switch position
    private boolean orderOn = false; // order to switch ON
    private boolean orderOff = false; // order to switch OFF

    public CSWI(LogicalNode logicalNode, ArrayList<String> meas){
        super(logicalNode, meas);
        setType(SclClass.LN_BODY);
    }

    @Override
    public void start(){
        Thread thread = new Thread(() -> {
            while (true) {
                pos = checkOrders();
                rebuildMeasures();
            }
        });
        thread.start();
    }

    @Override
    public void stop() {

    }

    @Override
    public void rebuildMeasures() {
        for (Data d: getMeasuresList()) {
            switch (d.getName()) {
                case "Mod":
                    d.setMean(pos);
                    break;
                case "OpOpn":
                    orderOn = Boolean.parseBoolean(String.valueOf(d.getMean()));
                    break;
                case "OpCls":
                    orderOff = Boolean.parseBoolean(String.valueOf(d.getMean()));
                    break;
            }
        }
    }

    public void configData(){
        for(Data dat: getMeasuresList()){
            switch (dat.getName()){
                case "Mod":
                    dat.setType(Data.Type.ONLY_READ);
                    dat.setMean(true);
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
