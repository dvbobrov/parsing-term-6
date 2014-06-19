import generators.LexerGenerator;
import generators.ParserGenerator;
import grammar.Grammar;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("usage: java Main <grammar file>");
            return;
        }
        String fileName = args[0];
        ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream(fileName));
        AntlrLexer lexer = new AntlrLexer(inputStream);
        AntlrParser parser = new AntlrParser(new CommonTokenStream(lexer));
        parser.antlrGrammar();

        Grammar grammar = parser.getGrammar();
        String name = parser.getGName();
        File path = new File("./generated/");
        if (!path.exists() && !path.mkdir()) {
            throw new RuntimeException("Cannot create directory");
        } else if (!path.isDirectory()) {
            throw new RuntimeException("./generated is not a directory");
        }

        try (FileWriter writer = new FileWriter(new File(path, name + "Lexer.java"))) {
            String genLexer = new LexerGenerator().generate(grammar, name);
            writer.write(genLexer);
        }

        new ParserGenerator(path).generate(grammar, name);
    }
}
