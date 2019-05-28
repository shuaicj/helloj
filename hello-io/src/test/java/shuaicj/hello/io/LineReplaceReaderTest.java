package shuaicj.hello.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LineReplaceReaderTest {

    @Test
    public void test() throws IOException {
        String s = "This is the LineReplaceReader test.\n"
                + "Each line will be replaced with the specified params.\n"
                + "Enjoy it.";
        Map<String, String> replaceMap = new HashMap<>();
        replaceMap.put("the", "---");
        replaceMap.put("will", "****");
        try (BufferedReader reader = new BufferedReader(new LineReplaceReader(replaceMap, new StringReader(s)))) {
            assertThat(reader.lines()).containsExactly(
                    "This is --- LineReplaceReader test.",
                    "Each line **** be replaced with --- specified params.",
                    "Enjoy it."
            );
        }
    }

}