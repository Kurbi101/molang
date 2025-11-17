package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class WhileNode extends StatementNode {
    private ExprNode condition;
    private ArrayList<StatementNode> body;

    public WhileNode(ExprNode condition, ArrayList<StatementNode> body) {
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
