package ModelVMD.VarAndTypeObj;

import ModelVMD.MmsObject;

public abstract class MmsVar extends MmsObject {



    private Object varMean;
    private boolean trip = false;
    private Object tripPoint;

    public Object getTripPoint() {
        return tripPoint;
    }

    public void setTripPoint(Object tripPoint) {
        this.tripPoint = tripPoint;
    }


    public boolean isTrip() {
        return trip=(varMean==tripPoint);
    }

    public void setTrip(boolean trip) {
        this.trip = trip;
    }

    public Object getVarMean() {
        return varMean;
    }

    public void setVarMean(Object varMean) {
        this.varMean = varMean;
    }


}
