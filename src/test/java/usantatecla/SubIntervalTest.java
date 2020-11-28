package usantatecla;

import org.junit.jupiter.api.Test;

public abstract class SubIntervalTest {

    protected SubInterval subInterval;

    @Test
    public abstract void givenSubIntervalWhenIsWithinWithLessValue();

    @Test
    public abstract void givenSubIntervalWhenIsWithinWithEqualsValue();

    @Test
    public abstract void givenSubIntervalWhenIsWithinWithGreaterValue();
}
