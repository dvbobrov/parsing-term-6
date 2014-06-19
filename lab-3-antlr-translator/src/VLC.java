import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.gui.SystemFontMetrics;

import java.io.*;
import java.util.Map;

public class VLC {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java VLC <filename>");
            return;
        }
        String fileName = args[0];
        ANTLRInputStream is;
        try {
            is = new ANTLRInputStream(new FileInputStream(new File(fileName)));
        } catch (IOException e) {
            System.err.println("");
            return;
        }

        Lexer lexer = new ValyriaLexer(is);
        TokenStream tokens = new CommonTokenStream(lexer);
        ValyriaParser parser = new ValyriaParser(tokens);
        parser.program();

        String file = parser.getClassName() + ".java";
        System.out.println("FILENAME: " + file);
        System.out.println(parser.getCode());

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(parser.getCode());
        }
        Process proc = Runtime.getRuntime().exec("javac " + file);
        try (BufferedReader errors = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
            String line;
            while ((line = errors.readLine()) != null) {
                System.err.println(line);
            }
        }

    }
}
