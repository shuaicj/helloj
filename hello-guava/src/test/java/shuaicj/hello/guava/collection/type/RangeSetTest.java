package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.junit.Test;

/**
 * Test RangeSet.
 *
 * @author shuaicj 2017/12/27
 */
public class RangeSetTest {

    @Test
    public void test() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(1, 5)); // {[1, 5]}
        assertThat(rangeSet.asRanges()).containsOnly(Range.closed(1, 5));

        rangeSet.add(Range.closedOpen(10, 16)); // {[1, 5], [10, 16)}
        assertThat(rangeSet.asRanges()).containsOnly(Range.closed(1, 5), Range.closedOpen(10, 16));

        rangeSet.add(Range.open(4, 8)); // {[1, 8), [10, 16)} auto merged!
        assertThat(rangeSet.asRanges()).containsOnly(Range.closedOpen(1, 8), Range.closedOpen(10, 16));

        rangeSet.remove(Range.closed(6, 7)); // {[1, 6), (7, 8), [10, 16)}
        assertThat(rangeSet.asRanges()).containsOnly(Range.closedOpen(1, 6), Range.open(7, 8), Range.closedOpen(10, 16));

        assertThat(rangeSet.contains(5)).isTrue();
        assertThat(rangeSet.contains(8)).isFalse();

        assertThat(rangeSet.rangeContaining(5)).isEqualTo(Range.closedOpen(1, 6));

        assertThat(rangeSet.encloses(Range.closed(2, 3))).isTrue();

        assertThat(rangeSet.span()).isEqualTo(Range.closedOpen(1, 16));
    }
}
