package usantatecla;

public abstract class SubInterval {

    protected double value;

    public SubInterval(double value) {
        this.value = value;
    }

    public abstract boolean isWithin(double value);

}
