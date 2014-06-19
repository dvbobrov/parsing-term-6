import com.dbobrov.labs.recursive_parsing.ParseException;
import com.dbobrov.labs.recursive_parsing.Parser;
import com.dbobrov.labs.recursive_parsing.logical_expression_nodes.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ParserTest {
    @Test
    public void variable() throws IOException, ParseException {
        String s = "a";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void or() throws IOException, ParseException {
        String s = "a or b";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null),
                new OrContinuation(new ConjunctionBegin(new NoNegation(new Var('b')), null), null));

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void xor() throws IOException, ParseException {
        String s = "a xor b";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null),
                new XorContinuation(new ConjunctionBegin(new NoNegation(new Var('b')), null), null));

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void orAssociativity() throws IOException, ParseException {
        String s = "a or b or c";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null),
                new OrContinuation(new ConjunctionBegin(new NoNegation(new Var('b')), null),
                        new OrContinuation(new ConjunctionBegin(new NoNegation(new Var('c')), null), null))
        );

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void and() throws IOException, ParseException {
        String s = "a and b";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')),
                new ConjunctionContinuation(new NoNegation(new Var('b')), null)), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void andAssociativity() throws IOException, ParseException {
        String s = "a and b and c";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')),
                new ConjunctionContinuation(new NoNegation(new Var('b')),
                        new ConjunctionContinuation(new NoNegation(new Var('c')), null))
        ), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void not() throws IOException, ParseException {
        String s = "not a";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new Negation(new NoNegation(new Var('a'))), null), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void doubleNegation() throws IOException, ParseException {
        String s = "not not a";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new Negation(
                new Negation(new NoNegation(new Var('a')))), null), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void priority() throws IOException, ParseException {
        String s = "a or not b and c";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null),
                new OrContinuation(new ConjunctionBegin(new Negation(new NoNegation(new Var('b'))),
                        new ConjunctionContinuation(new NoNegation(new Var('c')), null)), null)
        );

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void brackets() throws IOException, ParseException {
        String s = "(a or b) and c";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new ExpressionInParenthesis(
                new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null),
                        new OrContinuation(new ConjunctionBegin(new NoNegation(new Var('b')), null), null))
        )),
                new ConjunctionContinuation(new NoNegation(new Var('c')), null)
        ),
                null
        );

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void doubleBrackets() throws IOException, ParseException {
        String s = "((a))";
        Expression expr = new OrXorBegin(new ConjunctionBegin(new NoNegation(new ExpressionInParenthesis(
                new OrXorBegin(new ConjunctionBegin(new NoNegation(new ExpressionInParenthesis(
                        new OrXorBegin(new ConjunctionBegin(new NoNegation(new Var('a')), null), null)
                )), null), null)
        )), null), null);

        Assert.assertEquals(expr, Parser.parse(s));
    }

    @Test
    public void empty() {
        String s = "";
        try {
            Parser.parse(s);
            Assert.fail();
        } catch (ParseException ignore) {

        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void trash() {
        List<String> strings = Arrays.asList("(", "()", "a or or b", "a or not", "and a",
                "x xor y)", "a or b) or c", "a b c", "a and ()", "a (and b)");
        for (String s : strings) {
            try {
                Parser.parse(s);
                Assert.fail("Parsed inconsistent string " + s);
            } catch (ParseException ignore) {

            } catch (IOException e) {
                Assert.fail();
            }
        }
    }

    @Test(expected = NullPointerException.class)
    public void nullCheck() {
        new Parser(null);
    }

    @Test(expected = NullPointerException.class)
    public void nullCheck1() throws IOException, ParseException {
        Parser.parse((InputStream) null);
    }

    @Test(expected = NullPointerException.class)
    public void nullCheck2() throws IOException, ParseException {
        Parser.parse((String) null);
    }
}
