package generators;

import grammar.Grammar;
import grammar.Terminal;

public class LexerGenerator {
    private int off = 0;
    private StringBuilder builder;

    public String generate(Grammar grammar, String name) {
        builder = new StringBuilder();
        off = 0;
        try {
            String className = name + "Lexer";

            makeLine("import java.util.regex.*;");
            makeLine("import grammar.*;");
            makeLine("public class ", className, " {");
            off++;

            startLine().append("private boolean skip;\n");
            startLine().append("private String s;\n");
            startLine().append("private int pos;\n");
            startLine().append("private String cur;\n");
            startLine().append("private String curType;\n");

            startLine().append("public ").append(className).append("(String s) {\n");
            off++;
            startLine().append("this.s = s;\n");
            startLine().append("this.pos = 0;\n");
            startLine().append("goToNext();\n");
            off--;
            startLine().append("}\n");

            startLine().append("public String nextToken() {\n");
            off++;
            startLine().append("String res = cur;\n");
            startLine().append("if (curType.equals(\"EOF\")) {\n");
            off++;
            startLine().append("res = \"EOF\";\n");
            off--;
            startLine().append("} else {\n");
            off++;
            startLine().append("goToNext();\n");
            off--;
            startLine().append("}\n");
            startLine().append("return res;\n");
            off--;
            startLine().append("}\n");

            startLine().append("public void goToNext() {\n");
            off++;
            startLine().append("if (pos == s.length()) {\n");
            off++;
            makeLine("curType = \"EOF\";");
            makeLine("return;");
            leave();


            makeLine("boolean found = false;");
            makeLine("do {");
            off++;
            makeLine("skip = false;");
            makeLine("for (int i = s.length(); i > pos; i--) {");
            off++;
            for (Terminal terminal : grammar.terminals) {
                makeLine("if (tryGet", terminal.name, "(i)) {");
                off++;
                makeLine("found = true;");
                makeLine("break;");
                leave();
            }
            leave();

            off--;
            makeLine("} while(skip);");
            makeLine("if (!found) {");
            off++;
            makeLine("throw new GrammarException(\"No terminal matches string \" + s.substring(pos));");
            leave();
            leave();

            for (Terminal terminal : grammar.terminals) {
                makeLine("private boolean tryGet", terminal.name, "(int end) {");
                off++;
                makeLine("String maybeNext = s.substring(pos, end);");
                makeLine("if (!Pattern.matches(\"", terminal.regex, "\", maybeNext)) {");
                off++;
                makeLine("return false;");
                leave();
                makeLine("cur = maybeNext;");
                makeLine("pos = end;");
                makeLine("curType = \"", terminal.name, "\";");
                if (terminal.isSkippable) {
                    makeLine("skip = true;");
                }
                makeLine("return true;");
                leave();
            }

            makeLine("public String getCurType() {");
            off++;
            makeLine("return curType;");
            leave();
            leave();
            return builder.toString();
        } finally {
            builder = null;
        }
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
}
