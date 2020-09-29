package TerminalModel.SIMG;

import IedStructure.LogicalNode;
import IedStructure.SclClass;
import TerminalModel.Data;
import TerminalModel.NodeConnector;

import java.util.ArrayList;
import java.util.Random;

/**
 * HF6 protection service
 */
public class SIMG extends NodeConnector {

    private double temp; // температура
    private double den; // плотность
    private double pres; // давление
    // уставки по качествам
    private double tempTrip;
    private double denTrip;
    private double presTrip;
    private boolean tempAlm;
    private boolean denAlm;
    private boolean presAlm;

    public SIMG(LogicalNode logicalNode, ArrayList<String> meas){
        super(logicalNode, meas);
        setType(SclClass.LN_BODY);
    }

    @Override
    public void start() {

        Thread thread = new Thread(() -> {
            while (true){


                // сделать адекватный рандом
                Random rnd = new Random(System.currentTimeMillis());

                temp = 1 + rnd.nextInt(4 - 1);
                pres = 1 + rnd.nextInt(4 - 1);
                den = 1 + rnd.nextInt(4 - 1);

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void stop() {

    }

    public Object choice (String str){
        switch (str){
            case "Temp":
                return temp;
            case "Den":
                return den;
            case "Pres":
                return pres;
            case "PresAlm":
                return presAlm;
            case "TempAlm":
                return tempAlm;
            case "DenAlm":
                return denAlm;
            default:
                return null;
        }
    }

    @Override
    public void rebuildMeasures() {
        for (Data d: getMeasuresList()) {
            switch (d.getName()) {
                case "Temp":
                    d.setMean(temp);
                    break;
                case "Den":
                    d.setMean(den);
                    break;
                case "Pres":
                    d.setMean(pres);
                    break;
                case "PresAlm":
                    d.setMean(presAlm);
                    break;
                case "TempAlm":
                    d.setMean(tempAlm);
                    break;
                case "DenAlm":
                    d.setMean(denAlm);
                    break;
            }
        }
    }

    public void configData() {
        for (Data dat : getMeasuresList()) {
            switch (dat.getName()) {

                case "Temp":
                case "Den":
                case "Pres":
                    dat.setType(Data.Type.ONLY_READ);
                    break;
                case "PresAlm":
                    dat.setMean(presAlm);
                    dat.setType(Data.Type.ONLY_READ);
                    break;
                case "TempAlm":
                    dat.setMean(tempAlm);
                    dat.setType(Data.Type.ONLY_READ);
                    break;
                case "DenAlm":
                    dat.setMean(denAlm);
                    dat.setType(Data.Type.ONLY_READ);
                    break;

            }
        }
    }
}
