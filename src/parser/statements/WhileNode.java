package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class WhileNode extends StatementNode {
    private final ExprNode condition;
    private final ArrayList<StatementNode> body;
    public StatementKind kind = StatementKind.While;

    public WhileNode(ExprNode condition, ArrayList<StatementNode> body) {
        super(StatementKind.While);
        this.condition = condition;
        this.body = body;
    }

    public ExprNode getCondition() {
        return this.condition;
    }

    public ArrayList<StatementNode> getBody() {
        return this.body;
    }
}
