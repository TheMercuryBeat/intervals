package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenedMinTest extends SubIntervalTest {

    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.subInterval = this.createMin();
    }

    protected SubInterval createMin() {
        return new OpenedMin(this.point.getEquals());
    }

    @Test
    @Override
    public void givenSubIntervalWhenIsWithinWithLessValue() {
        assertFalse(this.subInterval.isWithin(this.point.getLess()));
    }

    @Test
    @Override
    public void givenSubIntervalWhenIsWithinWithEqualsValue() {
        assertFalse(this.subInterval.isWithin(this.point.getEquals()));
    }

    @Test
    @Override
    public void givenSubIntervalWhenIsWithinWithGreaterValue() {
        assertTrue(this.subInterval.isWithin(this.point.getGreater()));
    }

}

