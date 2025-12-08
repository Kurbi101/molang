package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class ForNode extends StatementNode {

    private final ExprNode init;
    private final ExprNode condition;
    private final ExprNode update;
    private final ArrayList<StatementNode> body;

    public ForNode(ExprNode preCondition, ExprNode condition, ExprNode postCondition, ArrayList<StatementNode> body) {
        super(StatementKind.For);
        this.init = preCondition;
        this.condition = condition;
        this.update = postCondition;
        this.body = body;
    }

    public ExprNode getInit() {
        return this.init;
    }

    public ExprNode getCondition() {
        return this.condition;
    }

    public ExprNode getUpdate() {
        return this.update;
    }

    public ArrayList<StatementNode> getBody() {
        return this.body;
    }
}
