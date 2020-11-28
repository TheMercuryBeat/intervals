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

        Point left = getPoint(-3.3);
        Point right = getPoint(-2.2);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).open(right.getEquals()).build();

        assertFalse(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheLeftThenShouldIntersect() {

        Point left = getPoint(-3.3);
        Point right = getPoint(-2.2);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).open(right.getGreater()).build();

        assertTrue(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheRightThenShouldNotIntersect() {

        Point left = getPoint(4.4);
        Point right = getPoint(7.7);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).open(right.getEquals()).build();

        assertFalse(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenOpenByTheRightThenShouldIntersect() {

        Point left = getPoint(4.4);
        Point right = getPoint(7.7);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getLess()).open(right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalClosedOpenWhenSecondIntervalOpenOpenByTheLeftThenShouldIntersect() {

        Point left = getPoint(-3.3);
        Point right = getPoint(-2.2);

        Interval firstInterval = intervalBuilderInstance().closed(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).open(right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalOpenOpenWhenSecondIntervalOpenClosedByTheLeftThenShouldIntersect() {

        Point left = getPoint(-3.3);
        Point right = getPoint(-2.2);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).closed(right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));

    }

    @Test
    public void givenFirstIntervalOpenClosedWhenSecondIntervalOpenOpenTheLeftThenShouldIntersect() {

        Point left = getPoint(4.4);
        Point right = getPoint(6.6);

        Interval firstInterval = intervalBuilderInstance().open(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval secondInterval = intervalBuilderInstance().open(left.getEquals()).open(right.getEquals()).build();

        assertTrue(firstInterval.intersects(secondInterval));

    }

    public static IntervalBuilder intervalBuilderInstance() {
        return new IntervalBuilder();
    }

    public Point getPoint(double value) {
        return new Point(value);
    }

}