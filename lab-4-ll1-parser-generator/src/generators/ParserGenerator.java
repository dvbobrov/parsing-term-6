package generators;

import grammar.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ParserGenerator {
    private final File root;

    private StringBuilder builder;
    private int off;

    public ParserGenerator(File root) {
        this.root = root;
    }

    public void generate(Grammar grammar, String name) {
        builder = new StringBuilder();
        makeLine("public abstract class Node {");
        off++;
        makeLine("Node[] children;");
        makeLine("public String text;");
        leave();
        writeToFile(builder.toString(), "Node.java");

        builder = new StringBuilder();
        makeLine("public class TerminalNode extends Node {");
        off++;
        makeLine("public TerminalNode(String text) {");
        off++;
        makeLine("this.text = text;");
        makeLine("children = new Node[0];");
        leave();
        leave();
        writeToFile(builder.toString(), "TerminalNode.java");

        builder = new StringBuilder();
        makeLine("public class Eps extends Node {");
        off++;
        makeLine("public Eps() {");
        off++;
        makeLine("this.text = \"EPS\";");
        makeLine("children = new Node[0];");
        leave();
        leave();
        writeToFile(builder.toString(), "Eps.java");

        for (NonTerminal nonTerminal : grammar.nonTerminals) {
            builder = new StringBuilder();

            makeLine("public class ", nonTerminal.name, " extends Node {");
            off++;

            nonTerminal.attributes
                    .forEach(at -> makeLine("public ", at.type, " ", at.name, ";"));

            leave();

            writeToFile(builder.toString(), nonTerminal.name + ".java");
        }

        builder = new StringBuilder();
        makeLine("import java.util.*;");
        makeLine("import java.util.stream.*;");
        makeLine("import grammar.GrammarException;");
        String className = name + "Parser";
        makeLine("public class ", className, " {");
        off++;

        makeLine("private ", name, "Lexer lexer;");
        makeLine("public ", className, "(", name, "Lexer lexer) {");
        off++;
        makeLine("this.lexer = lexer;");
        leave();

        for (NonTerminal nonTerminal : grammar.nonTerminals) {
            makeLine("public ", nonTerminal.name, " ", nonTerminal.name, "() {");
            off++;
            makeLine(nonTerminal.name, " res = new ", nonTerminal.name, "();");
            makeLine("switch (lexer.getCurType()) {");
            off++;
            for (Rule rule : nonTerminal.rules) {
                Collection<String> allowedTokens;
                if (rule.size() == 0) {
                    allowedTokens = nonTerminal.FOLLOW;
                } else {
                    Node first = rule.getChildAt(0);
                    if (first instanceof Terminal) {
                        allowedTokens = Arrays.asList(first.name);
                    } else {
                        allowedTokens = ((NonTerminal) first).FIRST;
                    }
                }

                allowedTokens.forEach(s -> makeLine("case \"", s, "\":"));
                if (rule.size() == 0) {
                    makeLine("case \"EOF\":");
                } else if (allowedTokens.size() == 0) {
                    throw new GrammarException("No token matches rule in " + nonTerminal.name);
                }
                makeLine("{");
                off++;
                if (rule.size() == 0) {
                    makeLine("res.children = new Node[] {");
                    off++;
                    makeLine("new Eps()");
                    off--;
                    makeLine("};");
                } else {
                    makeLine("res.children = new Node[", String.valueOf(rule.size()), "];");
                    for (int i = 0; i < rule.size(); i++) {
                        Node cur = rule.getChildAt(i);
                        if (cur instanceof NonTerminal) {
                            makeLine("res.children[", String.valueOf(i), "] = ", cur.name, "();");
                        } else {
                            makeLine("if (!\"", cur.name, "\".equals(lexer.getCurType())) {");
                            off++;
                            makeLine("throw new GrammarException(\"Unexpected token \" + lexer.nextToken());");
                            leave();
                            makeLine("res.children[", String.valueOf(i), "] = new TerminalNode(lexer.nextToken());");
                        }
                    }
                }
                makeLine("res.text = Arrays.stream(res.children).map(n -> n.text).collect(Collectors.joining(\" \"));");

                String code = rule.getCode();
                if (code != null) {
                    for (int i = 0; i < rule.size(); i++) {
                        Node n = rule.getChildAt(i);
                        if (n instanceof Terminal) {
                            code = code.replaceAll("\\$" + i, "res.children[" + i + "]");
                        } else {
                            code = code.replaceAll("\\$" + i, "((" + n.name + ")res.children[" + i + "])");
                        }
                    }
                    makeLine("{");
                    off++;
                    makeLine(code);
                    leave();
                }

                makeLine("break;");
                leave();
            }
            makeLine("default:");
            off++;
            makeLine("throw new GrammarException(\"Unexpected token: \" + lexer.getCurType());");
            off--;
            leave();
            makeLine("return res;");
            leave();
        }

        leave();
        writeToFile(builder.toString(), className + ".java");
    }

    private void leave() {
        off--;
        makeLine("}");
    }

    private void makeLine(String... args) {
        startLine();
        for (String s : args) {
            builder.append(s);
        }
        builder.append("\n");
    }

    private StringBuilder startLine() {
        for (int i = 0; i < off; i++) {
            builder.append("    ");
        }
        return builder;
    }


    private void writeToFile(String s, String fileName) {
        try (FileWriter writer = new FileWriter(new File(root, fileName))) {
            writer.write(s);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
