package TerminalModel.PDIS;

public class BlockManager {
    private double uA, uB, uC = 0;
    private double iA, iB,iC = 0;

    private boolean blocker;

    public double getTime() {
        return 0;
    }

    public void setTime(double time) {

    }

    public void setMeanU(int phase, double mean) {
        switch (phase) {
            case (0):
                this.uA = mean;
                break;
            case (1):
                this.uB = mean;
                break;
            case (2):
                this.uC = mean;
                break;
        }
    }

    public double getMeanU(int phase) {
        switch (phase) {
            case (0):
                return uA;
            case (1):
                return uB;
            case (2):
                return uC;
        }
        return -1;
    }

    public void setMeanI(int phase, double mean) {
        switch (phase) {
            case (0):
                this.iA = mean;
                break;
            case (1):
                this.iB = mean;
                break;
            case (2):
                this.iC = mean;
        }
    }

    public double getMeanI(int phase) {
        switch (phase) {
            case (0):
                return iA;
            case (1):
                return iB;
            case (2):
                return iC;
        }
        return -1;
    }

    public Boolean isBlocker() {
        return blocker;
    }

    public void setBlocker(boolean blocker) {
        this.blocker = blocker;
    }

    /**
     * если значение выше уставки, то блокировка срабатывает
     * @return True/False
     */
    public boolean isUnderBlock(double tripPoint) {

        blocker = compare(iA, tripPoint) ||
                compare(iB, tripPoint) ||
                compare(iC, tripPoint);
        return blocker;
    }

    public boolean isBlockedU(double tripPoint) {

        return compare(uA, tripPoint) ||
                compare(uB, tripPoint) ||
                compare(uC, tripPoint);
    }

    private boolean compare(double a, double b) {
        return (a > b);
    }
}
