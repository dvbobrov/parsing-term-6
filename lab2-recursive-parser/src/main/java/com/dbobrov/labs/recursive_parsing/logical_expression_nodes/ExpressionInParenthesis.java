package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class ExpressionInParenthesis extends T {
    @NotNull
    public final OrXorBegin child;

    public ExpressionInParenthesis(@NotNull OrXorBegin child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "'(' + " + child +
                " + ')'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressionInParenthesis that = (ExpressionInParenthesis) o;

        if (!child.equals(that.child)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return child.hashCode();
    }

    @Override
    public Expression[] getChildren() {
        return new Expression[]{
                new StringExpression("("),
                child,
                new StringExpression(")")
        };
    }
}
