package parser.definitions;

import parser.Symbol;

import java.util.ArrayList;

public record StructDefinition (Symbol id, ArrayList<StructField> fields, ArrayList<MethodDefinition> methods) {

}
