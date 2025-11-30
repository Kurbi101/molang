package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class IfNode extends StatementNode {
    private final ExprNode condition;
    private final ArrayList<StatementNode> body;
    private final ArrayList<StatementNode> elseBody;
    public static final StatementKind kind = StatementKind.If;

    public IfNode(ExprNode condition, ArrayList<StatementNode> body, ArrayList<StatementNode> elseBody) {
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }

    public ExprNode getCondition() {
        return this.condition;
    }

    public ArrayList<StatementNode> getBody() {
        return this.body;
    }

    public ArrayList<StatementNode> getElseBody() {
        return this.elseBody;
    }
}
