package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

public class Var extends T {
    public final char name;

    public Var(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Var(" + name + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Var)) return false;

        Var var = (Var) o;

        if (name != var.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) name;
    }

    @Override
    public Expression[] getChildren() {
        return new Expression[] {new StringExpression("" + name)};
    }
}
