package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class OrContinuation extends OrXorContinuation {
    public OrContinuation(@NotNull ConjunctionBegin first, OrXorContinuation second) {
        super(first, second);
    }

    @Override
    public String toString() {
        return "OrXorBegin'(or, " + first +
                ", " + second +
                ')';
    }

    @Override
    public Expression[] getChildren() {
        if (second == null) {
            return new Expression[]{new StringExpression("or"), first};
        } else {
            return new Expression[]{new StringExpression("or"), first, second};
        }
    }
}
