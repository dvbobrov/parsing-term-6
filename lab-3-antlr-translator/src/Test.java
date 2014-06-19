import java.lang.invoke.*;
import java.math.BigInteger;
import static stdlib.Util.*;
import stdlib.*;
import java.util.*;

public class Test{
    private static Map<String, MethodHandle> __functions;
    static {
        __functions = new HashMap<>();
        MethodHandles.Lookup __lookup = MethodHandles.lookup();
        try {
            __functions.put("print", __lookup.findStatic(Util.class, "print", MethodType.methodType(BigInteger.class, Object.class)));
            __functions.put("read", __lookup.findStatic(Util.class, "read", MethodType.methodType(BigInteger.class)));
            __functions.put("prime", __lookup.findStatic(Test.class, "prime", MethodType.methodType(BigInteger.class, BigInteger.class)));
            __functions.put("dec", __lookup.findStatic(Test.class, "dec", MethodType.methodType(BigInteger.class, BigInteger.class)));
            __functions.put("abs", __lookup.findStatic(Test.class, "abs", MethodType.methodType(BigInteger.class, BigInteger.class)));
            __functions.put("primeHelper", __lookup.findStatic(Test.class, "primeHelper", MethodType.methodType(BigInteger.class, BigInteger.class, BigInteger.class)));
            __functions.put("g", __lookup.findStatic(Test.class, "g", MethodType.methodType(BigInteger.class, MethodHandle.class, BigInteger.class)));
        } catch (Exception e) { throw new AssertionError(); }
    }
    public static BigInteger prime(BigInteger n) throws Throwable {
        BigInteger __res;
        if (!(n.compareTo(new BigInteger("2")) < 0 ? BigInteger.ONE : BigInteger.ZERO).equals(BigInteger.ZERO)) {
            __res = (new BigInteger("0"));
        } else {
            __res = primeHelper(n, dec(n));
        }
        return __res;
    }
    public static BigInteger dec(BigInteger x) throws Throwable {
        BigInteger __res;
        __res = (x.subtract(new BigInteger("1")));
        return __res;
    }
    public static BigInteger abs(BigInteger n) throws Throwable {
        BigInteger __res;
        if (!__not(((n.compareTo(new BigInteger("0")) >= 0 ? BigInteger.ONE : BigInteger.ZERO))).equals(BigInteger.ZERO)) {
            __res = (new BigInteger("0").subtract(n));
        } else {
            __res = (n);
        }
        return __res;
    }
    public static BigInteger primeHelper(BigInteger n, BigInteger i) throws Throwable {
        BigInteger __res;
        if (!(i.compareTo(new BigInteger("1")) == 0 ? BigInteger.ONE : BigInteger.ZERO).equals(BigInteger.ZERO)) {
            __res = (new BigInteger("1"));
        } else {
            if (!(n.mod(i).compareTo(new BigInteger("0")) == 0 ? BigInteger.ONE : BigInteger.ZERO).equals(BigInteger.ZERO)) {
                __res = (new BigInteger("0"));
            } else {
                __res = primeHelper(n, dec(i));
            }
        }
        return __res;
    }
    public static BigInteger g(MethodHandle f, BigInteger a) throws Throwable {
        BigInteger __res;
        __res = ((BigInteger)f.invokeExact(a));
        return __res;
    }
    public static void main(String[] __args) throws Throwable {
        BigInteger __res;
        __res = print(g(__functions.get("prime"), read()));
    }
}