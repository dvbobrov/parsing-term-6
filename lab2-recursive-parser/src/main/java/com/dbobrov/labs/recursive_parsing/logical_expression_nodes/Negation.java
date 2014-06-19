package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class Negation extends MaybeNegation {
    @NotNull
    public final MaybeNegation child;

    public Negation(@NotNull MaybeNegation child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "N(not, " + child +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Negation negation = (Negation) o;

        if (!child.equals(negation.child)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return child.hashCode();
    }

    @Override
    public Expression[] getChildren() {
        return new Expression[] {
                new StringExpression("not"),
                child
        };
    }
}
