package shuaicj.hello.commons.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Test the library commons-cli.
 *
 * @author shuaicj 2017/01/10
 */
public class CommonsCliTest {

    @Test
    public void testShortOption() throws Exception {
        Options options = new Options();
//        options.addOption(Option.builder("a").build());
//        options.addOption(Option.builder("b").build());
        options.addOption("a", "description of a");
        options.addOption("b", "description of b");
        assertThat(parse(options, new String[]{"-a"}).hasOption("a")).isTrue();
        assertThat(parse(options, new String[]{"-ab"}).hasOption("a")).isTrue();
        assertThat(parse(options, new String[]{"-ab"}).hasOption("b")).isTrue();
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> parse(options, new String[]{"--a"}));
    }

    @Test
    public void testLongOption() throws Exception {
        Options options = new Options();
//        options.addOption(Option.builder().longOpt("all-all").build());
        options.addOption(null, "all-all", false, "description of a");
        assertThat(parse(options, new String[]{"-all-all"}).hasOption("all-all")).isTrue();
        assertThat(parse(options, new String[]{"--all-all"}).hasOption("all-all")).isTrue();
    }

    @Test
    public void testShortAndLongOption() throws Exception {
        Options options = new Options();
        options.addOption(Option.builder("a").longOpt("all-all").build());
        assertThat(parse(options, new String[]{"-a"}).hasOption("a")).isTrue();
        assertThat(parse(options, new String[]{"-a"}).hasOption("all-all")).isTrue();
        assertThat(parse(options, new String[]{"-all-all"}).hasOption("a")).isTrue();
        assertThat(parse(options, new String[]{"-all-all"}).hasOption("all-all")).isTrue();
        assertThat(parse(options, new String[]{"--all-all"}).hasOption("a")).isTrue();
        assertThat(parse(options, new String[]{"--all-all"}).hasOption("all-all")).isTrue();
    }

    @Test
    public void testRequiredOption() throws Exception {
        Options options1 = new Options();
        options1.addOption(Option.builder("a").build());
        assertThat(parse(options1, new String[]{""}).hasOption("a")).isFalse();
        Options options2 = new Options();
        options2.addOption(Option.builder("a").required().build());
        assertThat(parse(options2, new String[]{"-a"}).hasOption("a")).isTrue();
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> parse(options2, new String[]{""}));
    }

    @Test
    public void testOneArg() throws Exception {
        Options options = new Options();
        options.addOption(Option.builder("a").hasArg().build());
        assertThat(parse(options, new String[]{"-a=me"}).getOptionValue("a")).isEqualTo("me");
        assertThat(parse(options, new String[]{"-ame"}).getOptionValue("a")).isEqualTo("me");
        assertThat(parse(options, new String[]{"-a", "me"}).getOptionValue("a")).isEqualTo("me");
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> parse(options, new String[]{"-a"}));
    }

    @Test
    public void testMultiArgs() throws Exception {
        Options options = new Options();
        options.addOption(Option.builder().longOpt("all-all").hasArgs().valueSeparator(',').build());
        assertThat(parse(options, new String[]{"--all-all=me"}).getOptionValues("all-all")).containsExactly("me");
        assertThat(parse(options, new String[]{"--all-all", "me"}).getOptionValues("all-all")).containsExactly("me");
        assertThat(parse(options, new String[]{"--all-all=me,you,him"}).getOptionValues("all-all")).containsExactly("me", "you", "him");
        assertThat(parse(options, new String[]{"--all-all", "me,you,him"}).getOptionValues("all-all")).containsExactly("me", "you", "him");
        assertThat(parse(options, new String[]{"--all-all", "me", "you", "him"}).getOptionValues("all-all")).containsExactly("me", "you", "him");
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> parse(options, new String[]{"--all-all"}));
    }

    @Test
    public void testPrintUsage() throws Exception {
        Options options = new Options();
        options.addOption("a", "description of a");
        options.addOption("b", "bbbb", false, "description of b");
        options.addOption("c", "ccc", true, "description of c");
        HelpFormatter formatter = new HelpFormatter();
        StringWriter writer = new StringWriter();
        formatter.printHelp(new PrintWriter(writer),
                HelpFormatter.DEFAULT_WIDTH,
                "cmd",
                "",
                options,
                HelpFormatter.DEFAULT_LEFT_PAD,
                HelpFormatter.DEFAULT_DESC_PAD,
                "");
        assertThat(writer.toString()).isEqualTo("usage: cmd\n" +
                " -a               description of a\n" +
                " -b,--bbbb        description of b\n" +
                " -c,--ccc <arg>   description of c\n");
    }

    private CommandLine parse(Options options, String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }
}
