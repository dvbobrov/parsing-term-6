package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

public class StringExpression implements Expression {
    private final String str;

    public StringExpression(String str) {
        this.str = str;
    }

    @Override
    public String getLabel() {
        return str;
    }

    @Override
    public Expression[] getChildren() {
        return new Expression[0];
    }
}
