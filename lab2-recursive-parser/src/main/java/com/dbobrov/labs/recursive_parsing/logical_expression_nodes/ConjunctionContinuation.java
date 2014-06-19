package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class ConjunctionContinuation implements Expression {
    @NotNull
    public final MaybeNegation first;
    public final ConjunctionContinuation second;

    public ConjunctionContinuation(@NotNull MaybeNegation first, ConjunctionContinuation second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "A'(" + first +
                ", " + second +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConjunctionContinuation that = (ConjunctionContinuation) o;

        if (!first.equals(that.first)) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String getLabel() {
        return "A'";
    }

    @Override
    public Expression[] getChildren() {
        if (second == null) {
            return new Expression[]{new StringExpression("and"), first};
        } else {
            return new Expression[]{new StringExpression("and"), first, second};
        }
    }
}
