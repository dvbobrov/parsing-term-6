package com.dbobrov.labs.recursive_parsing;

import com.dbobrov.labs.recursive_parsing.logical_expression_nodes.*;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Parser implements Closeable {
    @NotNull
    private final LexicalAnalyzer lexer;
    private int bracketBalance = 0;

    public Parser(@NotNull LexicalAnalyzer lexer) {
        Objects.requireNonNull(lexer);
        this.lexer = lexer;
    }

    public static Expression parse(@NotNull String s) throws IOException, ParseException {
        Objects.requireNonNull(s);
        try (InputStream is = new ByteArrayInputStream(s.getBytes())) {
            return parse(is);
        }
    }

    public static Expression parse(@NotNull InputStream inputStream) throws IOException, ParseException {
        Objects.requireNonNull(inputStream);
        try (LexicalAnalyzer lexer = new LexicalAnalyzer(inputStream);
             Parser parser = new Parser(lexer)) {
            return parser.parse();
        }
    }

    public Expression parse() throws ParseException {
        lexer.nextToken();
        return O();
    }

    private OrXorBegin O() throws ParseException {
        ConjunctionBegin first;
        OrXorContinuation second;
        switch (lexer.getTokenType()) {
            case NOT:
            case LEFT_PARENTHESIS:
            case VAR:
                first = A();
                break;
            default:
                throwUnexpectedToken();
                return null;
        }
        second = OPrime();
        return new OrXorBegin(first, second);
    }

    private ConjunctionBegin A() throws ParseException {
        MaybeNegation first;
        ConjunctionContinuation second;
        switch (lexer.getTokenType()) {
            case NOT:
            case LEFT_PARENTHESIS:
            case VAR:
                first = N();
                break;
            default:
                throwUnexpectedToken();
                return null;
        }
        second = APrime();
        return new ConjunctionBegin(first, second);
    }

    private MaybeNegation N() throws ParseException {
        switch (lexer.getTokenType()) {
            case NOT: {
                lexer.nextToken();
                return new Negation(N());
            }
            case LEFT_PARENTHESIS:
            case VAR:
                return new NoNegation(T());
            default:
                throwUnexpectedToken();
                return null;
        }
    }

    private T T() throws ParseException {
        switch (lexer.getTokenType()) {
            case VAR: {
                VarParameters params = (VarParameters) lexer.getTokenParameters();
                lexer.nextToken();
                return new Var(params.getName());
            }
            case LEFT_PARENTHESIS: {
                bracketBalance++;
                lexer.nextToken();
                OrXorBegin child = O();
                if (lexer.getTokenType() != TokenType.RIGHT_PARENTHESIS) {
                    throw new ParseException(") expected at position " + lexer.getCurrentPosition());
                }
                bracketBalance--;
                lexer.nextToken();
                return new ExpressionInParenthesis(child);
            }
            default:
                throwUnexpectedToken();
                return null;
        }
    }

    private OrXorContinuation OPrime() throws ParseException {
        switch (lexer.getTokenType()) {
            case OR: {
                lexer.nextToken();
                ConjunctionBegin first = A();
                OrXorContinuation second = OPrime();
                return new OrContinuation(first, second);
            }
            case XOR: {
                lexer.nextToken();
                ConjunctionBegin first = A();
                OrXorContinuation second = OPrime();
                return new XorContinuation(first, second);
            }
            case RIGHT_PARENTHESIS:
                if (bracketBalance == 0) {
                    throwUnexpectedToken();
                }
            case END:
                return null;
            default:
                throwUnexpectedToken();
                return null;
        }
    }

    private ConjunctionContinuation APrime() throws ParseException {
        switch (lexer.getTokenType()) {
            case AND: {
                lexer.nextToken();
                MaybeNegation first = N();
                ConjunctionContinuation second = APrime();
                return new ConjunctionContinuation(first, second);
            }
            case RIGHT_PARENTHESIS:
                if (bracketBalance == 0) {
                    throwUnexpectedToken();
                }
            case END:
            case OR:
            case XOR:
                return null;
            default:
                throwUnexpectedToken();
                return null;
        }
    }

    private void throwUnexpectedToken() throws ParseException {
        throw new ParseException("Unexpected token " + lexer.getTokenType() + " at position " + lexer.getCurrentPosition());
    }

    @Override
    public void close() throws IOException {
        lexer.close();
    }
}
