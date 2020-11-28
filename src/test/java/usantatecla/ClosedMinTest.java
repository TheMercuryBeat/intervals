package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClosedMinTest extends MinTest {

    @Override
    protected SubInterval createMin() {
        return new ClosedMin(this.point.getEquals());
    }

    @Test
    @Override
    public void givenSubIntervalWhenIsWithinWithEqualsValue() {
        assertTrue(this.subInterval.isWithin(this.point.getEquals()));
    }

}
