package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

public abstract class MaybeNegation implements Expression {
    @Override
    public String getLabel() {
        return "N";
    }
}
