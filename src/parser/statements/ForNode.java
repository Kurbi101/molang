package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class ForNode extends StatementNode {

    private ExprNode preCondition;
    private ExprNode condition;
    private ExprNode postCondition;
    private ArrayList<StatementNode> body;

    public ForNode(ExprNode preCondition, ExprNode condition, ExprNode postCondition, ArrayList<StatementNode> body) {
        this.preCondition = preCondition;
        this.condition = condition;
        this.postCondition = postCondition;
        this.body = body;
    }

    public ExprNode getPreCondition() {
        return this.preCondition;
    }

    public ExprNode getCondition() {
        return this.condition;
    }

    public ExprNode getPostCondition() {
        return this.postCondition;
    }

    public ArrayList<StatementNode> getBody() {
        return this.body;
    }
}
