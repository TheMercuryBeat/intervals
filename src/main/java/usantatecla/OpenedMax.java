package usantatecla;

public class OpenedMax extends SubInterval {

    public OpenedMax(double value) {
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
