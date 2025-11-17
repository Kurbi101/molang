package parser.expressions;

import parser.Symbol;
import types.Type;

import java.util.ArrayList;

public class MethodCallNode extends ExprNode {
    private final ExprNode object;
    private final Symbol method;
    private final ArrayList<ExprNode> args;
    private final Type type;

    public MethodCallNode(ExprNode object, Symbol method, ArrayList<ExprNode> args, Type type) {
        this.object = object;
        this.method = method;
        this.args = args;
        this.type = type;
    }

    public ExprNode getObject() {
        return this.object;
    }

    public Symbol getMethod() {
        return this.method;
    }

    public ArrayList<ExprNode> getArgs() {
        return this.args;
    }

    public Type evaluateType() {
        return this.type;
    }
}
