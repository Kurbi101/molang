package parser.definitions;

import parser.Symbol;

import java.util.ArrayList;

public class StructDefinition {
    private Symbol id;
    private ArrayList<StructField> fields;
    private ArrayList<MethodDefinition> methods;
}
