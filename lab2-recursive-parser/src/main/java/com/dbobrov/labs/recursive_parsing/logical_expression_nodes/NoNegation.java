package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class NoNegation extends MaybeNegation {
    @NotNull
    public final T child;

    public NoNegation(@NotNull T child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "N(" + child +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoNegation noNegation = (NoNegation) o;

        if (!child.equals(noNegation.child)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return child.hashCode();
    }

    @Override
    public Expression[] getChildren() {
        return new Expression[] {child};
    }
}
