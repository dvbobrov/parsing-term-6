package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class XorContinuation extends OrXorContinuation {
    public XorContinuation(@NotNull ConjunctionBegin first, OrXorContinuation second) {
        super(first, second);
    }

    @Override
    public String toString() {
        return "OrXorBegin'(xor, " + first +
                ", " + second +
                ')';
    }

    @Override
    public Expression[] getChildren() {
        if (second == null) {
            return new Expression[]{new StringExpression("xor"), first};
        } else {
            return new Expression[]{new StringExpression("xor"), first, second};
        }
    }
}
