package parser.definitions;

import parser.Symbol;
import types.Type;

import java.util.ArrayList;
import parser.statements.StatementNode;

public class FunctionDefinition {
    private final Symbol id;
    private final Type returnType;
    private final ArrayList<Argument> params;
    private final ArrayList<StatementNode> body;

    public FunctionDefinition(Symbol id, Type returnType, ArrayList<Argument> params, ArrayList<StatementNode> body) {
        this.id = id;
        this.returnType = returnType;
        this.params = params;
        this.body = body;
    }

    public Symbol getId() {
        return this.id;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public ArrayList<Argument> getParams() {
        return this.params;
    }

    public ArrayList<StatementNode> getBody() {
        return this.body;
    }
}
