package TerminalModel.PDIS;

public class RelayLogicManager {

    private final double KOEF = 0.85; // коэффициент отстройки
    private final double KOEF_2 = 0.9; // коэффициент отстройки
    private final double LINE_LENGTH = 273 * 3; // km
    private final double ACT_RES = 0.048; // active resistance per km
    private final double IND_RES = 0.328; // inductive resistance per km
    private final double CAP_RES = 0.293; // capacitive resistance per km

    private double impedance = Math.sqrt(Math.pow(LINE_LENGTH * ACT_RES, 2)
            + Math.pow(LINE_LENGTH * (IND_RES - CAP_RES), 2));

    private double cutOffTrip = KOEF * impedance; // ток срабатывания отсечки

    private double minTripPoint = KOEF * (impedance + KOEF_2 * cutOffTrip); // миниальный ток срабатывания защиты


    private double timeWait, iniTime; // время до срабатывания защиты / время пуска защиты
    private double timeSet = Double.POSITIVE_INFINITY; // время срабатывания защиты
    private boolean boo, key = false;

    private DigitSignal digitSignal;
    private BlockManager bl;

    public DigitSignal getDigitSignal() {
        return digitSignal;
    }

    void setDigitSignal(DigitSignal digitSignal) {
        this.digitSignal = digitSignal;
    }

    void setBlockManager(BlockManager bl) {
        this.bl = bl;
    }

    boolean process() {
        if (digitSignal.isTriggered(minTripPoint)) {

            setTrip(true);
            timeWait = digitSignal.getTime() - iniTime;
//            System.out.println(
//                    "До отключения осталось: " + (timeSet - timeWait));
        }
        else setTrip(false);

        if (timeWait >= timeSet) boo = true; // флаг срабатывания защиты


        return boo;
    }

    private void launchAuthority(){
        if (!key) { // однократная логика пуска защиты
            iniTime = digitSignal.getTime();
            key = true;

            if (digitSignal.isTriggered(cutOffTrip)) timeSet = 1000; // время срабатывания токовой отсечки
            else timeSet = 50000; // время срабатывания ДЗ
        }}

    private void delaunchAuthority(){
        if(!digitSignal.isTriggered(0.95 * minTripPoint) ){ // дребезг
            key = false;
            timeSet = Double.POSITIVE_INFINITY;
        }}

    private void setTrip(boolean trip) {
//        System.out.println(bl.isUnderBlock(10));
        if (trip & bl.isUnderBlock(10)) launchAuthority(); // условие отключения блокировки
        else delaunchAuthority();
    }

    public Double getCutOffTrip() {
        return cutOffTrip;
    }

    public void setCutOffTrip(double cutOffTrip) {
        this.cutOffTrip = cutOffTrip;
    }

    public Double getMinTripPoint() {
        return minTripPoint;
    }

    public void setMinTripPoint(double minTripPoint) {
        this.minTripPoint = minTripPoint;
    }

    public Boolean isBoo() {
        return boo;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

}


