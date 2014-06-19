package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

import org.jetbrains.annotations.NotNull;

public class OrXorBegin implements Expression {
    @NotNull
    public final ConjunctionBegin first;
    public final OrXorContinuation second;

    public OrXorBegin(@NotNull ConjunctionBegin first, OrXorContinuation second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "O(" + first +
                ", " + second +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrXorBegin that = (OrXorBegin) o;

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
        return "O";
    }

    @Override
    public Expression[] getChildren() {
        if (second == null) {
            return new Expression[]{first};
        } else {
            return new Expression[]{first, second};
        }
    }
}
