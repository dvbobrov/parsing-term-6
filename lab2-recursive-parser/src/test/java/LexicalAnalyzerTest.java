import com.dbobrov.labs.recursive_parsing.LexicalAnalyzer;
import com.dbobrov.labs.recursive_parsing.ParseException;
import com.dbobrov.labs.recursive_parsing.TokenType;
import com.dbobrov.labs.recursive_parsing.VarParameters;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LexicalAnalyzerTest {
    @Test
    public void var() throws IOException, ParseException {
        String data = "a";

        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            analyzer.nextToken();
            assertThat(analyzer.getTokenType(), is(TokenType.VAR));
            VarParameters parameters = (VarParameters) analyzer.getTokenParameters();
            assertThat(parameters.getName(), is('a'));

            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void emptyString() throws IOException, ParseException {
        String data = "";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void paren() throws ParseException, IOException {
        String data = "(a)";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.LEFT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.RIGHT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void and() throws IOException, ParseException {
        String data = "a and b";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.AND));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void or() throws IOException, ParseException {
        String data = "a or b";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.OR));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void xor() throws IOException, ParseException {
        String data = "a xor b";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.XOR));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void not() throws IOException, ParseException {
        String data = "not a";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.NOT));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void doubleParen() throws IOException, ParseException {
        String data = "((a))";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.LEFT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.LEFT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            assertThat(analyzer.nextToken(), is(TokenType.RIGHT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.RIGHT_PARENTHESIS));
            assertThat(analyzer.nextToken(), is(TokenType.END));
        }
    }

    @Test
    public void wrongToken0() throws IOException {
        String data = "aba";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            try {
                analyzer.nextToken();
                Assert.fail("Wrong token passed");
            } catch (ParseException ignore) {
            }
        }
    }

    @Test
    public void wrongToken1() throws IOException, ParseException {
        String data = "a xar b";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            try {
                analyzer.nextToken();
                Assert.fail("Wrong token passed");
            } catch (ParseException ignore) {
            }
        }
    }

    @Test
    public void wrongToken2() throws IOException, ParseException {
        String data = "a & b";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            assertThat(analyzer.nextToken(), is(TokenType.VAR));
            try {
                analyzer.nextToken();
                Assert.fail("Wrong token passed");
            } catch (ParseException ignore) {
            }
        }
    }

    @Test
    public void wrongToken3() throws IOException, ParseException {
        String data = "nota";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        try (LexicalAnalyzer analyzer = new LexicalAnalyzer(stream)) {
            try {
                analyzer.nextToken();
                Assert.fail("Wrong token passed");
            } catch (ParseException ignore) {
            }
        }
    }
}
