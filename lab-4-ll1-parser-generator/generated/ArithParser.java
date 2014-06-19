import java.util.*;
import java.util.stream.*;
import grammar.GrammarException;
public class ArithParser {
    private ArithLexer lexer;
    public ArithParser(ArithLexer lexer) {
        this.lexer = lexer;
    }
    public sum sum() {
        sum res = new sum();
        switch (lexer.getCurType()) {
            case "NUM":
            case "PL":
            {
                res.children = new Node[2];
                res.children[0] = mul();
                res.children[1] = sumC();
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = ((mul)res.children[0]).val + ((sumC)res.children[1]).val;
                }
                break;
            }
            default:
                throw new GrammarException("Unexpected token: " + lexer.getCurType());
        }
        return res;
    }
    public sumC sumC() {
        sumC res = new sumC();
        switch (lexer.getCurType()) {
            case "PLUS":
            {
                res.children = new Node[3];
                if (!"PLUS".equals(lexer.getCurType())) {
                    throw new GrammarException("Unexpected token " + lexer.nextToken());
                }
                res.children[0] = new TerminalNode(lexer.nextToken());
                res.children[1] = mul();
                res.children[2] = sumC();
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = ((mul)res.children[1]).val + ((sumC)res.children[2]).val;
                }
                break;
            }
            case "PR":
            case "EOF":
            {
                res.children = new Node[] {
                    new Eps()
                };
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = 0;
                }
                break;
            }
            default:
                throw new GrammarException("Unexpected token: " + lexer.getCurType());
        }
        return res;
    }
    public mul mul() {
        mul res = new mul();
        switch (lexer.getCurType()) {
            case "NUM":
            case "PL":
            {
                res.children = new Node[2];
                res.children[0] = t();
                res.children[1] = mulC();
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = ((t)res.children[0]).val * ((mulC)res.children[1]).val;
                }
                break;
            }
            default:
                throw new GrammarException("Unexpected token: " + lexer.getCurType());
        }
        return res;
    }
    public mulC mulC() {
        mulC res = new mulC();
        switch (lexer.getCurType()) {
            case "STAR":
            {
                res.children = new Node[3];
                if (!"STAR".equals(lexer.getCurType())) {
                    throw new GrammarException("Unexpected token " + lexer.nextToken());
                }
                res.children[0] = new TerminalNode(lexer.nextToken());
                res.children[1] = t();
                res.children[2] = mulC();
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = ((t)res.children[1]).val * ((mulC)res.children[2]).val;
                }
                break;
            }
            case "PR":
            case "PLUS":
            case "EOF":
            {
                res.children = new Node[] {
                    new Eps()
                };
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = 1;
                }
                break;
            }
            default:
                throw new GrammarException("Unexpected token: " + lexer.getCurType());
        }
        return res;
    }
    public t t() {
        t res = new t();
        switch (lexer.getCurType()) {
            case "PL":
            {
                res.children = new Node[3];
                if (!"PL".equals(lexer.getCurType())) {
                    throw new GrammarException("Unexpected token " + lexer.nextToken());
                }
                res.children[0] = new TerminalNode(lexer.nextToken());
                res.children[1] = sum();
                if (!"PR".equals(lexer.getCurType())) {
                    throw new GrammarException("Unexpected token " + lexer.nextToken());
                }
                res.children[2] = new TerminalNode(lexer.nextToken());
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = ((sum)res.children[1]).val;
                }
                break;
            }
            case "NUM":
            {
                res.children = new Node[1];
                if (!"NUM".equals(lexer.getCurType())) {
                    throw new GrammarException("Unexpected token " + lexer.nextToken());
                }
                res.children[0] = new TerminalNode(lexer.nextToken());
                res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(" "));
                {
                    res.val = Integer.parseInt(res.children[0].text);
                }
                break;
            }
            default:
                throw new GrammarException("Unexpected token: " + lexer.getCurType());
        }
        return res;
    }
}
