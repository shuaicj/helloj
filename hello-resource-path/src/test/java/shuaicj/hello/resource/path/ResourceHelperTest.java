package shuaicj.hello.resource.path;


import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test ResourceHelper.
 *
 * @author shuaicj 2017/01/20
 */
public class ResourceHelperTest {

    private ResourceHelper helper = new ResourceHelper();

    @Test
    public void getAbsolutePath() throws Exception {
        String path = helper.getAbsolutePath("name.txt");
        System.out.println("path " + path);
        List<String> lines = Files.readAllLines(Paths.get(path));
        assertThat(lines).containsExactly("shuaicj");
    }

}