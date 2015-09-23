package exercise2;

/**
 * Created by Fabian Gillholm on 2015-09-22.
 */
public class Passenger {
    protected int fee = 20;
    protected boolean isEmbarked = false;

    public void embark() {
        this.isEmbarked = true;
    }

    public void disembark() {
        this.isEmbarked = false;
    }

    public boolean embarked() {
        return this.isEmbarked;
    }

    public int getFee() {
        return this.fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
