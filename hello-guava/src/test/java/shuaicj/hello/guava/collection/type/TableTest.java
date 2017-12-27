package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

/**
 * Test Table.
 *
 * @author shuaicj 2017/12/27
 */
public class TableTest {

    @Test
    public void test() {
        Table<String, String, String> t = HashBasedTable.create();
        t.put("r1", "c1", "v1");
        t.put("r1", "c2", "v2");
        t.put("r2", "c1", "v3");
        t.put("r2", "c2", "v3");

        assertThat(t.contains("r1", "c1")).isTrue();
        assertThat(t.contains("r1", "c3")).isFalse();
        assertThat(t.containsRow("r1")).isTrue();
        assertThat(t.containsRow("r3")).isFalse();
        assertThat(t.containsColumn("c2")).isTrue();
        assertThat(t.containsColumn("c3")).isFalse();
        assertThat(t.containsValue("v3")).isTrue();
        assertThat(t.containsValue("v4")).isFalse();

        assertThat(t.get("r1", "c2")).isEqualTo("v2");
        assertThat(t.get("r1", "c3")).isNull();

        assertThat(t.size()).isEqualTo(4);

        assertThat(t.row("r1")).containsOnly(entry("c1", "v1"), entry("c2", "v2"));
        assertThat(t.row("r2")).containsOnly(entry("c1", "v3"), entry("c2", "v3"));
        assertThat(t.column("c1")).containsOnly(entry("r1", "v1"), entry("r2", "v3"));
        assertThat(t.column("c2")).containsOnly(entry("r1", "v2"), entry("r2", "v3"));

        assertThat(t.values()).containsExactlyInAnyOrder("v1", "v2", "v3", "v3");

        t.remove("r1", "c1");

        assertThat(t.size()).isEqualTo(3);
        assertThat(t.values()).containsExactlyInAnyOrder("v2", "v3", "v3");
    }
}
