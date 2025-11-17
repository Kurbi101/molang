package parser.expressions;

import java.util.ArrayList;

import parser.Symbol;
import types.Type;

public class FunctionCallNode extends ExprNode {
    private final Symbol id;
    private final ArrayList<ExprNode> args;
    private final Type type;

    public FunctionCallNode(Symbol id, ArrayList<ExprNode> args, Type type) {
        this.id = id;
        this.args = args;
        this.type = type;
    }

    public Symbol getId() {
        return this.id;
    }

    public ArrayList<ExprNode> getArgs() {
        return this.args;
    }

    public Type evaluateType() {
        return this.type;
    }
}
