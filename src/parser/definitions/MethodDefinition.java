package parser.definitions;

import parser.Symbol;
import parser.statements.StatementNode;
import types.Type;

import java.util.ArrayList;

public class MethodDefinition extends FunctionDefinition {
    private final boolean isStatic;
    private final Symbol caller;

    public boolean isStatic() {
        return isStatic;
    }

    public Symbol getCaller() {
        return this.caller;
    }

    public MethodDefinition(Symbol id, Type returnType, ArrayList<Argument> params, ArrayList<StatementNode> body, boolean isStatic, Symbol caller) {
        super(id, returnType, params, body);
        this.isStatic = isStatic;
        this.caller = caller;
    }
}
