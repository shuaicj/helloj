package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

/**
 * Test RangeMap.
 *
 * @author shuaicj 2017/12/27
 */
public class RangeMapTest {

    @Test
    public void test() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.closed(1, 5), "a"); // {[1, 5] => "a"}
        assertThat(rangeMap.asMapOfRanges()).containsOnly(entry(Range.closed(1, 5), "a"));

        rangeMap.put(Range.closedOpen(10, 16), "b"); // {[1, 5] => "a", [10, 16) => "b"}
        assertThat(rangeMap.asMapOfRanges()).containsOnly(
                entry(Range.closed(1, 5), "a"),
                entry(Range.closedOpen(10, 16), "b")
        );

        rangeMap.put(Range.openClosed(15, 19), "b"); // {[1, 5] => "a", [10, 15] => "b", (15, 19] => "b"}
                                                     // unlike RangeSet, not auto merged here
        assertThat(rangeMap.asMapOfRanges()).containsOnly(
                entry(Range.closed(1, 5), "a"),
                entry(Range.closed(10, 15), "b"),
                entry(Range.openClosed(15, 19), "b")
        );

        rangeMap.putCoalescing(Range.closed(13, 20), "b"); // {[1, 5] => "a", [10, 20] => "b"}
                                                           // putCoalescing() will do auto merge
        assertThat(rangeMap.asMapOfRanges()).containsOnly(
                entry(Range.closed(1, 5), "a"),
                entry(Range.closed(10, 20), "b")
        );

        rangeMap.put(Range.closed(12, 15), "c"); // {[1, 5] => "a", [10, 12) => "b", [12, 15] => "c", (15, 20] => "b"}
        assertThat(rangeMap.asMapOfRanges()).containsOnly(
                entry(Range.closed(1, 5), "a"),
                entry(Range.closedOpen(10, 12), "b"),
                entry(Range.closed(12, 15), "c"),
                entry(Range.openClosed(15, 20), "b")
        );

        rangeMap.remove(Range.closed(9, 16)); // {[1, 5] => "a", (16, 20] => "b"}
        assertThat(rangeMap.asMapOfRanges()).containsOnly(
                entry(Range.closed(1, 5), "a"),
                entry(Range.openClosed(16, 20), "b")
        );

        assertThat(rangeMap.get(3)).isEqualTo("a");
        assertThat(rangeMap.get(6)).isNull();
        assertThat(rangeMap.getEntry(3)).isEqualTo(entry(Range.closed(1, 5), "a"));
        assertThat(rangeMap.getEntry(6)).isNull();
    }
}
