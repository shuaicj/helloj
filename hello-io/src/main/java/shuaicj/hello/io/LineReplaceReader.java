package shuaicj.hello.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.Map;

/**
 * The wrap reader to replace each line of the input reader.
 * Every line will apply {@link String#replace(CharSequence, CharSequence)}.
 * See https://stackoverflow.com/questions/50799710/java-dynamic-string-replacement-inside-a-reader-stream.
 *
 * @author shuaicj 2019/05/28
 */
public class LineReplaceReader extends Reader {

   /**
     * The replace map with K: target, V: replacement. See {@link #replaceLine(String)}.
     */
    private Map<String, String> replaceMap;

    /**
     * Wrap the real input reader as a BufferedReader so we can read by line.
     */
    private BufferedReader input;

    /**
     * Buffer the current line.
     */
    private StringReader output;

    public LineReplaceReader(String target, String replacement, Reader in) {
        this(Collections.singletonMap(target, replacement), in);
    }

    public LineReplaceReader(Map<String, String> replaceMap, Reader in) {
        this.replaceMap = replaceMap;
        this.input = new BufferedReader(in);
        this.output = new StringReader("");
    }

    @Override
    public int read(char[] buf, int off, int len) throws IOException {
        int read = 0;
        while (len > 0) {
            int num = output.read(buf, off, len); // first read the buffered line
            if (num == -1) { // the buffered line is empty
                String line = input.readLine(); // so try read a new line
                if (line == null) { // no new line
                    break;
                }
                line = replaceLine(line); // do replace
                line += "\n"; // add "\n" which was removed by input.readLine()
                output = new StringReader(line); // set the buffered line
            } else {
                read += num;
                off += num;
                len -= num;
            }
        }
        return read == 0 ? -1 : read;
    }

    @Override
    public void close() throws IOException {
        input.close();
        output.close();
    }

    private String replaceLine(String line) {
        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
            line = line.replace(entry.getKey(), entry.getValue());
        }
        return line;
    }
}
