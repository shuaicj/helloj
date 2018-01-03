package shuaicj.hello.guava.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.junit.Test;

/**
 * Test Files.
 *
 * @author shuaicj 2018/01/03
 */
public class FilesTest {

    private static final String PATH = Thread.currentThread().getContextClassLoader()
            .getResource("guava/io/test.txt").getPath();

    @Test
    public void readLines() throws IOException {
        List<String> lines = Files.asCharSource(new File(PATH), Charsets.UTF_8).readLines();
        assertThat(lines).containsExactly("abc", "d", "ef");
    }

    @Test
    @SuppressWarnings("deprecation")
    public void hash() throws IOException {
        HashCode code = Files.asByteSource(new File(PATH)).hash(Hashing.md5());
        assertThat(code.toString()).isEqualTo("1dbb10159fd4710690fa83ed95089292");
    }

    @Test
    public void getFileExtension() throws IOException {
        String fullname = new File(PATH).getName();
        assertThat(Files.getFileExtension(fullname)).isEqualTo("txt");
    }

    @Test
    public void getNameWithoutExtension() throws IOException {
        String fullname = new File(PATH).getName();
        assertThat(Files.getNameWithoutExtension(fullname)).isEqualTo("test");
    }

    @Test
    public void copy() throws IOException {
        File src = new File(PATH);
        File dst = new File(src.getParent() + "/test.txt.dst");
        Files.copy(src, dst);
        assertThat(Files.asCharSource(dst, Charsets.UTF_8).readLines()).containsExactly("abc", "d", "ef");
    }

    @Test
    public void create() throws IOException {
        File f = new File(new File(PATH).getParent() + "/a/b/c/file.txt");
        Files.createParentDirs(f);
        assertThat(f.getParentFile()).exists().isDirectory();
    }
}
