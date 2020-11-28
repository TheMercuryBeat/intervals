package usantatecla;

public class Max extends SubInterval {

    public Max(double value) {
        super(value);
    }

    public boolean isWithin(double value) {
        return this.value > value;
    }

    @Override
    public String toString() {
        return this.value + ")";
    }

}
