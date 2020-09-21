package TerminalModel.PDIS;

import CodeProcessing.ConfigWorker;
import IedStructure.IED;
import IedStructure.LogicalNode;
import IedStructure.SclClass;
import SclBodies.SCL;
import TerminalModel.Data;
import TerminalModel.NodeConnector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/** Класс считывания, расчета и визуализации данных
        */
public class ProcessDataManager extends NodeConnector {

    private File comtrCfg, comtrDat; // конфигурационный/файл данных
    private double[] k1, k2; // масштабные коэффициенты

    private ImpedanceManager im = new ImpedanceManager();
    private DigitSignal digitSignal = new DigitSignal();
    private BlockManager bm = new BlockManager();
    private RelayLogicManager relayManager = new RelayLogicManager();

    public ProcessDataManager(LogicalNode node, ArrayList<String> meanList) {
        super(node, meanList);
        setType(SclClass.LN_BODY);
        // внимательно с путем файла
        String path = "C:\\Users\\Alexander\\JavaProjects\\MMS-Service\\src\\main\\java\\TerminalModel\\PDIS\\data\\";

        /*
        1ph: KZ4 = KZ7
        2ph: KZ1 > KZ3 = KZ5 = KZ6
        3ph: KZ2
         */
        // задание фильтрам соответствующих векторов

        // задание логике РЗ соответствующих классов сигналов и блокировки
        im.setDS(digitSignal);
        relayManager.setDigitSignal(digitSignal);
        im.setBlockManager(bm);
        relayManager.setBlockManager(bm);

        String comtrName = "KZ1";
        String cfgName = path + comtrName + ".cfg"; // имя конфигурационного файла
        comtrCfg = new File(cfgName); // конфигурационный файл
        String datName = path + comtrName + ".dat"; // имя файла данных
        comtrDat = new File(datName); // файл данных
    }

    @Override
    public void start() throws IOException {


        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    // парсинг конфигурации файла
                    while (!relayManager.isBoo()) {
                        parseConfigFile(comtrCfg);
                        // обработка значений
                        makeDataProcessing(comtrDat);
                    }
                    Thread.sleep(10000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();



    }

    @Override
    public void stop() {

    }

    /**
     * обработка конфигурационного Комтрейд-файла
     *
     * @param file файл конфигурации
     * @throws IOException
     */
    private void parseConfigFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));


        int lineNumber, count, numberData, flagNumber;
        lineNumber = count = numberData = flagNumber = 0;

        String line;

        while ((line = br.readLine()) != null) {
            lineNumber++;
            if (lineNumber == 2) {
                flagNumber = lineNumber;
                numberData = Integer.parseInt(line.split(",")[1].replaceAll("A", ""));
                k1 = new double[numberData];
                k2 = new double[numberData];

            } else if (lineNumber > 2 && lineNumber <= numberData + flagNumber) {

                k1[count] = Double.parseDouble(line.split(",")[5]);
                k2[count] = Double.parseDouble(line.split(",")[6]);

                count++;

            }
        }
    }

    /**
     * обработка данных Комтрейд-файла
     *
     * @param file файл, из которого производится чтение
     * @throws IOException
     */
    private void makeDataProcessing(File file) throws IOException {

        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        outer:
        while ((line = br.readLine()) != null) { // outer - метка для выхода из внешнего цикла
            count++;

            if (count < 2000) continue; // позволяет срезать часть графика в норм режиме

            String[] lineData = line.split(",");
            digitSignal.setTime(Double.parseDouble(lineData[1]));

            for (int phase = 0; phase < 3; phase++) {

                double U = Double.parseDouble(lineData[phase + 2]) * k1[phase] + k2[phase];
                double I = Double.parseDouble(lineData[phase + 5]) * k1[phase + 3] + k2[phase + 3];
                im.setImpedance(U, I, phase);


                if (relayManager.process()) {
                    System.out.println(digitSignal.getTime());
                    System.out.println("Защита сработала");
                    rebuildMeasures();
                    break outer; // при срабатывании защиты происходит выход
                }

                rebuildMeasures();


            }
        }
    }

    @Override
    public void rebuildMeasures() {
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, ((IED) getDadByType(SclClass.IED)).getSclLink());
        for (Data d: getMes()) {
            switch (d.getName()) {
                case "BlkZn":
                    d.setMean(bm.isBlocker());
                    break;
                case "CutTrip":
                    relayManager.setCutOffTrip((Double) d.getMean());
                break;
                case "Str":
                    d.setMean(relayManager.isBoo());
                    break;
            }
        }
    }

    public void configData(){
        for(Data dat: getMes()){
            switch (dat.getName()){
                case "BlkZn":
                    dat.setType(Data.Type.ONLY_READ);
                    break;
                case "CutTrip":
                    dat.setType(Data.Type.ONLY_OPERATE);
                    dat.setMean(relayManager.getCutOffTrip());
                    break;
                case "Str":
                    dat.setType(Data.Type.ONLY_READ);;
                    break;
            }
        }
    }
}
