package com.dbobrov.labs.recursive_parsing.logical_expression_nodes;

public interface Expression {
    String getLabel();
    Expression[] getChildren();
}
