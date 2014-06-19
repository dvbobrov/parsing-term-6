package stdlib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Dmitry on 02.06.2014.
 */
public class Util {
    private static class Reader {
        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer tokenizer;

        public static String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    line = null;
                }
                if (line != null) {
                    tokenizer = new StringTokenizer(line);
                } else {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

    }

    public static BigInteger __not(BigInteger i) {
        if (i.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return BigInteger.ZERO;
    }

    public static BigInteger print(Object o) {
        System.out.println(o);
        return BigInteger.ZERO;
    }

    public static BigInteger read() {
        String token = Reader.nextToken();
        if (token == null) {
            throw new RuntimeException("No more tokens");
        }
        BigInteger val = new BigInteger(token);
        return val;
    }
}
