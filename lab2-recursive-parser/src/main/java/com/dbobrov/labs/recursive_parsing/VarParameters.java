package com.dbobrov.labs.recursive_parsing;

public class VarParameters implements TokenParameters {
    private final char name;

    public VarParameters(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}
