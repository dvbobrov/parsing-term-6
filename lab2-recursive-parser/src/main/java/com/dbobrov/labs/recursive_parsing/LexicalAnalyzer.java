package com.dbobrov.labs.recursive_parsing;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;

public class LexicalAnalyzer implements Closeable {
    private final BufferedReader reader;
    private TokenType tokenType;
    private TokenParameters tokenParameters;
    private int currentChar;
    private int currentPosition = -1;

    public LexicalAnalyzer(@NotNull InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    public TokenType nextToken() throws ParseException {
        if (tokenType == TokenType.END) {
            throw new IllegalStateException("Unexpected call to nextToken(): stream already ended");
        }

        tokenType = null;
        tokenParameters = null;

        try {


            while (currentPosition < 0 || Character.isSpaceChar((char) currentChar)) {
                if (nextChar() == -1) break;
            }

            switch (currentChar) {
                case -1:
                    tokenType = TokenType.END;
                    break;
                case '(':
                    tokenType = TokenType.LEFT_PARENTHESIS;
                    nextChar();
                    break;
                case ')':
                    tokenType = TokenType.RIGHT_PARENTHESIS;
                    nextChar();
                    break;
                default:
                    char c = (char) currentChar;
                    if (Character.isLetter(c)) {
                        StringBuilder builder = new StringBuilder()
                                .append(c);
                        c = (char) nextChar();
                        while (currentChar != -1 && Character.isLetter(c)) {
                            builder.append(c);
                            c = (char) nextChar();
                        }
                        String token = builder.toString();
                        if (token.length() == 1) {
                            tokenType = TokenType.VAR;
                            tokenParameters = new VarParameters(token.charAt(0));
                        } else {
                            switch (token) {
                                case "and":
                                    tokenType = TokenType.AND;
                                    break;
                                case "or":
                                    tokenType = TokenType.OR;
                                    break;
                                case "xor":
                                    tokenType = TokenType.XOR;
                                    break;
                                case "not":
                                    tokenType = TokenType.NOT;
                                    break;
                                default:
                                    throw new ParseException(String.format("Unexpected token %s at position %d",
                                            token, currentPosition));
                            }
                        }
                    } else {
                        throw new ParseException(String.format("Unexpected symbol %c at position %d",
                                c, currentPosition));
                    }
            }
        } catch (IOException e) {
            throw new ParseException("IO error", e);
        }

        return tokenType;
    }

    public TokenParameters getTokenParameters() {
        if (tokenParameters == null) {
            throw new IllegalStateException("Unexpected call to getTokenParameters(): token doesn't have any");
        }
        return tokenParameters;
    }

    public TokenType getTokenType() {
        if (tokenType == null) {
            throw new IllegalStateException("Unexpected call to getTokenType(): no tokens available");
        }
        return tokenType;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    private int nextChar() throws IOException {
        if ((currentChar = reader.read()) != -1) {
            currentPosition++;
        }
        return currentChar;
    }
}
