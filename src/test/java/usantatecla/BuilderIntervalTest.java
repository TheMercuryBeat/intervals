package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderIntervalTest {

    private double min;
    private double max;

    @BeforeEach
    public void before() {
        this.min = -2.2;
        this.max = 4.4;
    }

    @Test
    public void givenIntervalBuilderWhenOpenOpen() {
        Interval interval = new IntervalBuilder().open(this.min).open(this.max).build();
        assertEquals(interval, new Interval(new OpenedMin(this.min), new OpenedMax(this.max)));
    }

    @Test
    public void givenIntervalBuilderWhenOpenClosed() {
        Interval interval = new IntervalBuilder().open(this.min).closed(this.max).build();
        assertEquals(interval, new Interval(new OpenedMin(this.min), new ClosedMax(this.max)));
    }

    @Test
    public void givenIntervalBuilderWhenClosedOpen() {
        Interval interval = new IntervalBuilder().closed(this.min).open(this.max).build();
        assertEquals(interval, new Interval(new ClosedMin(this.min), new OpenedMax(this.max)));
    }

    @Test
    public void givenIntervalBuilderWhenClosedClosed() {
        Interval interval = new IntervalBuilder().closed(this.min).closed(this.max).build();
        assertEquals(interval, new Interval(new ClosedMin(this.min), new ClosedMax(this.max)));
    }

}
