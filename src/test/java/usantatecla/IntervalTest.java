package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilderInstance().open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilderInstance().closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = intervalBuilderInstance().open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = intervalBuilderInstance().closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }


    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheLeftThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getLess()).open(this.left.getEquals()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheLeftThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getLess()).open(this.left.getGreater()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheRightThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.right.getEquals()).open(this.right.getGreater()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheRightThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.right.getLess()).open(this.right.getGreater()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalClosedOpenWhenSecondIntervalOpenOpenByTheLeftThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().closed(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getLess()).open(this.left.getEquals()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenClosedByTheLeftThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getLess()).closed(this.left.getEquals()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenClosedWhenSecondIntervalOpenOpenTheRightThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.right.getEquals()).open(this.right.getGreater()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalClosedOpenTheRightThenShouldNotIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().closed(this.right.getEquals()).open(this.right.getGreater()).build();

        assertFalse(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalClosedOpenWhenSecondIntervalOpenClosedByTheLeftThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().closed(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getLess()).closed(this.left.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenClosedWhenSecondIntervalClosedOpenByTheRightThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().closed(this.right.getEquals()).open(this.right.getGreater()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenAreTheSameThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalClosedClosedWhenSecondIntervalClosedClosedAreTheSameThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().closed(this.left.getEquals()).closed(this.right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    @Test
    public void givenFirstIntervalOpenClosedWhenSecondIntervalClosedOpenAreTheSameThenShouldIntersect() {

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().closed(this.left.getEquals()).open(this.right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));
    }

    public static IntervalBuilder intervalBuilderInstance() {
        return new IntervalBuilder();
    }

}