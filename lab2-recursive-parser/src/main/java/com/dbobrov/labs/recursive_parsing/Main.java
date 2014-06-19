package com.dbobrov.labs.recursive_parsing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        for (String s : args) {
            System.out.println(Parser.parse(s));
        }
    }
}
