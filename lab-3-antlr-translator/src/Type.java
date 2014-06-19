import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Type {
    public static final int INT = 0;
    public static final int FUNCTION = 1;

    public final int typeId;

    private final Type returnType;
    private final List<Type> params;

    public Type getReturnType() {
        if (typeId != FUNCTION) {
            throw new RuntimeException("type is not a function");
        }
        return returnType;
    }

    public List<Type> getParams() {
        if (typeId != FUNCTION) {
            throw new RuntimeException("type is not a function");
        }
        return params;
    }

    @Override
    public String toString() {
        if (typeId == INT) {
            return "Int";
        }

        String param = params.stream().map(Type::toString).collect(Collectors.joining(", ", "(", ")"));
        return param + " -> " + returnType.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (this == obj) return true;

        Type other = (Type) obj;
        if (other.typeId != typeId) return false;
        if (typeId == INT) return true;
        return returnType.equals(other.returnType) && params.equals(other.params);
    }

    public static Type function(Type returnType, List<Type> params) {
        return new Type(FUNCTION, returnType, params);
    }

    public static Type integer() {
        return new Type(INT, null, null);
    }

    private Type(int id, Type returnType, List<Type> params) {
        typeId = id;
        this.returnType = returnType;
        this.params = params;
    }
}
