package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

public abstract class T implements Expression {
    @Override
    public String getLabel() {
        return "T";
    }
}
