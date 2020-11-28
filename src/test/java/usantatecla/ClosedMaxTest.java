package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected SubInterval createMax() {
        return new ClosedMax(this.point.getEquals());
    }

    @Test
    @Override
    public void givenSubIntervalWhenIsWithinWithEqualsValue() {
        assertTrue(this.subInterval.isWithin(this.point.getEquals()));
    }

}
