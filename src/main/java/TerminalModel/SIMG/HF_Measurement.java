package TerminalModel.SIMG;

import IecStructure.LogicalNode;
import TerminalModel.PDIS.MmsConnector;

import java.util.ArrayList;
import java.util.Random;

public class HF_Measurement extends MmsConnector {

    private double temp;
    private double den;
    private double pres;
    // уставки по качествам
    private double tempTrip;
    private double denTrip;
    private double presTrip;
    private boolean tempAlm;
    private boolean denAlm;
    private boolean presAlm;

    public HF_Measurement(LogicalNode logicalNode, ArrayList<String> meas){
        logicalNode.setMeasruments(takeCareOfMms(meas));
        setLogicalNode(logicalNode);
    }

    @Override
    public void start() {

        Thread thread = new Thread(() -> {
            while (true){

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
    public void setNewMeas() {
        String[] list = (String[]) getMeasures().keySet().toArray();
        for (int i = 0; i <= list.length; i++) {
            switch (list[i]) {
                case "Temp":
                    setMean(list[i], temp);
                    break;
                case "Den":
                    setMean(list[i], den);
                    break;
                case "Pres":
                    setMean(list[i], pres);
                    break;
                case "PresAlm":
                    setMean(list[i], presAlm);
                    break;
                case "TempAlm":
                    setMean(list[i], tempAlm);
                    break;
                case "DenAlm":
                    setMean(list[i], denAlm);
                    break;

            }
        }
    }
}