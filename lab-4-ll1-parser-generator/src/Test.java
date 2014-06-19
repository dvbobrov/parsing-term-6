import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import grammar.GrammarException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String read = reader.readLine();
            builder.append(read);
        }

        ArithLexer lexer = new ArithLexer(builder.toString());
        ArithParser parser = new ArithParser(lexer);
        sum sum = parser.sum();
        System.out.println(sum.val);
//
//        PascalLELexer lexer = new PascalLELexer(builder.toString());
//        PascalLEParser parser = new PascalLEParser(lexer);
//        orXor orXor = parser.orXor();
//        if (!lexer.getCurType().equals("EOF")) {
//            throw new GrammarException("EOF not reached");
//        }
//        System.out.println(orXor.text);
    }
}
