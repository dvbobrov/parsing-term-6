grammar Valyria;

@header {
import java.util.*;
import java.util.stream.*;
import java.lang.StringBuilder;
}

@members {
int offset;
String packageName;
String className;

Map<String, String> functions;
Map<String, List<Type>> paramTypes;
Map<String, List<String>> paramNames;
Map<String, Type> returnTypes;

String fName;
StringBuilder fBody;
List<Type> fParams;
List<String> fParamNames;
Type fReturnType;

Type lastTypeDesc;

String getClassName() {
    return className;
}

String getPackage() {
    return packageName;
}

String getCode() {
    StringBuilder sb = new StringBuilder();
    header(sb);

    for (Map.Entry<String, String> fun : functions.entrySet()) {
        String name = fun.getKey();
        List<String> params = paramNames.get(name);
        List<Type> types = paramTypes.get(name);
        if (name.equals("main")) {
            if (paramNames.get("main").size() != 0) {
                throw new RuntimeException("main function should take no arguments");
            }
            sb.append("    public static void main(String[] __args) throws Throwable {\n");
        } else {
            sb.append("    public static BigInteger ").append(name).append("(");

            for (int i = 0; i < params.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                Type t = types.get(i);
                sb.append(t.typeId == Type.INT ? "BigInteger " : "MethodHandle ").append(params.get(i));
            }

            sb.append(") throws Throwable {\n");
        }
        sb.append(fun.getValue());
        sb.append("    }\n");
    }

    offset--;
    sb.append("}");
    return sb.toString();
}

String off() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < offset; i++) {
        sb.append("    ");
    }
    return sb.toString();
}

void header(StringBuilder sb) {
    offset = 0;
    if (packageName != null && !"".equals(packageName)) {
        sb.append("package ").append(packageName.substring(0, packageName.length() - 1)).append(";\n");
    }

    sb.append("import java.lang.invoke.*;\n");
    sb.append("import java.math.BigInteger;\n");
    sb.append("import static stdlib.Util.*;\n");
    sb.append("import stdlib.*;\n");
    sb.append("import java.util.*;\n\n");
    sb.append("public class ").append(className).append("{\n");
    offset++;
    sb.append(off()).append("private static Map<String, MethodHandle> __functions;\n");
    sb.append(off()).append("static {\n");
    offset++;
    sb.append(off()).append("__functions = new HashMap<>();\n");
    sb.append(off())
        .append("MethodHandles.Lookup __lookup = MethodHandles.lookup();\n")
        .append(off())
        .append("try {\n");

    offset++;

    sb.append(off()).append("__functions.put(\"print\", ")
        .append("__lookup.findStatic(Util.class, \"print\", MethodType.methodType(BigInteger.class, Object.class)));\n")
        .append(off()).append("__functions.put(\"read\", ")
        .append("__lookup.findStatic(Util.class, \"read\", MethodType.methodType(BigInteger.class)));\n");

    for (String name : functions.keySet()) {
        if (name.equals("main")) {
            continue;
        }
        List<Type> params = paramTypes.get(name);
        String lookupType = params.stream()
            .map(t -> t.typeId == Type.INT ? "BigInteger.class" : "MethodHandle.class")
            .collect(Collectors.joining(", "));

        sb.append(off()).append("__functions.put(\"").append(name).append("\", ");

        sb.append("__lookup.findStatic(")
            .append(className)
            .append(".class, \"")
            .append(name)
            .append("\", MethodType.methodType(")
            .append("BigInteger.class, ")
            .append(lookupType)
            .append(")));\n");
    }
    offset--;
    sb.append(off()).append("} catch (Exception e) { throw new AssertionError(); }\n");
    offset--;
    sb.append(off()).append("}\n");
}

void init() {
    functions = new HashMap<>();
    paramTypes = new HashMap<>();
    List<Type> specialParams = new ArrayList<>();
    specialParams.add(Type.integer());
    paramTypes.put("print", specialParams);
    paramTypes.put("read", new ArrayList<>());
    
    paramNames = new HashMap<>();
    List<String> specialParamNames = new ArrayList<>();
    specialParamNames.add("o");
    paramNames.put("print", specialParamNames);
    paramNames.put("read", new ArrayList<>());
    
    returnTypes = new HashMap<>();
    returnTypes.put("print", Type.integer());
    returnTypes.put("read", Type.integer());
    
    offset = 1;
}

String muldiv(String text) {
    switch(text) {
        case "*":
            return "multiply";
        case "/":
            return "divide";
        case "%":
            return "mod";
    }
    throw new AssertionError();
}
}


program : {
    init();
} MODULE qualifiedName functionList
;

functionList : (function)*
;

function : typeDesc {
    fParams = lastTypeDesc.getParams();
    fReturnType = lastTypeDesc.getReturnType();
} IDENTIFIER {
    fName = $IDENTIFIER.text;
    fBody = new StringBuilder();
    fParamNames = new ArrayList<String>();
} paramsList {
    if (fParams.size() != fParamNames.size()) {
        throw new RuntimeException("Parameters and signature for function " + fName + " do not match");
    }

    paramTypes.put(fName, fParams);
    paramNames.put(fName, fParamNames);
    offset++;
    fBody.append(off()).append("BigInteger __res;\n");
} EQ expr[false] {
    if (!$IDENTIFIER.text.equals("main")) {
        fBody.append(off()).append("return __res;\n");
    }
    functions.put(fName, fBody.toString());
    offset--;
}
;

typeDesc : {
    List<Type> paramList = new ArrayList<>();
    Type[] returnType = new Type[1];
} PL (pType[paramList] (COMMA pType[paramList])* )* PR RARR rType[returnType] {
    if (returnType[0] == null) {
        throw new AssertionError();
    }
    lastTypeDesc = Type.function(returnType[0], paramList);
}
;

pType[List<Type> paramList] : INT { paramList.add(Type.integer()); } | PL typeDesc { paramList.add(lastTypeDesc); } PR
;

rType[Type[] returnType] : INT { returnType[0] = Type.integer(); }
;

paramsList : (IDENTIFIER {
    fParamNames.add($IDENTIFIER.text);
})*
;

expr[boolean in] : SL {
    if (!in) {
        fBody.append(off()).append("__res = ");
    }
} funCall {
    if (!in) {
        fBody.append(";\n");
    }
}  SR | IF {
    fBody.append(off()).append("if (!");
} PL expr[true] {
    fBody.append(".equals(BigInteger.ZERO)) {\n");
    offset++;
} PR expr[in] {
    offset--;
    fBody.append(off()).append("} else {\n");
    offset++;
} ELSE expr[in] {
    offset--;
    fBody.append(off()).append("}\n");
} | {
    if (!in) {
        fBody.append(off()).append("__res = ");
    }
} boolExpr {
    if (!in) {
        fBody.append(";\n");
    }
}
;

funCall : IDENTIFIER {
    if ($IDENTIFIER.text.equals("main")) {
        throw new RuntimeException("can't call main");
    }
    
    int paramNumber = fParamNames.indexOf($IDENTIFIER.text);
    
    if (paramNumber != -1) {
        fBody.append("((BigInteger)").append($IDENTIFIER.text).append(".invokeExact(");
    } else if (paramTypes.containsKey($IDENTIFIER.text)) {
        fBody.append($IDENTIFIER.text).append("(");
    } else {
        throw new RuntimeException("Can't find function " + $IDENTIFIER.text);
    }
    
    List<Type> cParamTypes = new ArrayList<>();
} (callParams[cParamTypes])? {
    if (paramNumber != -1) {
        fBody.append("))");
        if (!fParams.get(paramNumber).equals(Type.function(Type.integer(), cParamTypes))) {
            throw new RuntimeException("Parameter types for function parameter " 
            + $IDENTIFIER.text + " inside function " + fName + " definition mismatch");                                                                  
        }
    } else {
        fBody.append(")");
        if (!Type.function(Type.integer(), paramTypes.get($IDENTIFIER.text)).equals(Type.function(Type.integer(), cParamTypes))) {
            throw new RuntimeException("Parameter types for function parameter " 
            + $IDENTIFIER.text + " inside function " + fName + " definition mismatch");                                                                  
        }
    }
}
;

boolExpr : conjunction (OR {
    fBody.append(".or(");
} conjunction {
    fBody.append(")");
})*
;

conjunction: neg (AND {
    fBody.append(".and(");
} neg {
    fBody.append(")");
})*
;

neg : compExpr | NOT {
    fBody.append("__not(");
} compExpr {
    fBody.append(")");
}
;

compExpr : {
    fBody.append("(");
    String compType = null;
} arithExpr (comp {
    fBody.append(".compareTo(");
} arithExpr {
    fBody.append(") ");
    fBody.append($comp.text).append(" 0 ? BigInteger.ONE : BigInteger.ZERO");
})? {
    fBody.append(")");
}
;

arithExpr : mul (PLUSMINUS {
    switch ($PLUSMINUS.text) {
        case "+":
            fBody.append(".add(");
            break;
        case "-":
            fBody.append(".subtract(");
            break;
    }
} mul {
    fBody.append(")");
})*
;

mul : factor (MULDIV {
    fBody.append(".").append(muldiv($MULDIV.text)).append("(");
} factor {
    fBody.append(")");
})*
;

factor : IDENTIFIER {
    fBody.append($IDENTIFIER.text);
} | NUMBER {
    fBody.append("new BigInteger(\"").append($NUMBER.text).append("\")");
} | SL funCall SR | PL expr[true] PR
;

callParams[List<Type> cParamTypes] : callParam[cParamTypes] ({
    fBody.append(", ");
} callParam[cParamTypes])*
;

callParam[List<Type> cParamTypes] : NUMBER {
    fBody.append("new BigInteger(\"").append($NUMBER.text).append("\")");
    cParamTypes.add(Type.integer());
} | IDENTIFIER {
    int argNum = fParamNames.indexOf($IDENTIFIER.text);
    if (argNum != -1) {
        fBody.append($IDENTIFIER.text);
        Type type = fParams.get(argNum);
        cParamTypes.add(type);
    } else if (paramTypes.containsKey($IDENTIFIER.text)) {
        fBody.append("__functions.get(\"").append($IDENTIFIER.text).append("\")");
        cParamTypes.add(Type.function(Type.integer(), paramTypes.get($IDENTIFIER.text)));
    } else {
        throw new RuntimeException("Can't find function " + $IDENTIFIER.text);    
    }
} | SL funCall {
    cParamTypes.add(Type.integer());
} SR
;

qualifiedName : packageName {
    packageName = $packageName.text;
}
IDENTIFIER {
    className = $IDENTIFIER.text;
}
;

packageName : (IDENTIFIER DOT)*
;

comp : COMP | NEQ;

MODULE : 'module';
INT : 'Int';
COMMA : ',';
B : ('\n' | '\r' | '\t' | ' ') -> skip;
EQ : '=';
AND : '&&';
OR : '||';
NOT : '!';
PLUSMINUS : '+' | '-';
MULDIV : '*' | '/' | '%';
COMP : '>=' | '<=' | '<' | '>' | '==';
NEQ : '/=' { setText("!="); };
DOT : '.';
IF : 'if';
ELSE : 'else';
SL : '[';
SR : ']';
PL : '(';
PR : ')';
NUMBER : [0-9]+;
RARR : '->';
IDENTIFIER : [A-Za-z_] ([A-Za-z_0-9])*;
