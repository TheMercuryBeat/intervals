package usantatecla;

public class OpenedMin extends SubInterval {

    public OpenedMin(double value) {
        super(value);
    }

    public boolean isWithin(double value) {
        return this.value < value;
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }

}
