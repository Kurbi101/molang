package parser.statements;

import parser.expressions.ExprNode;

import java.util.ArrayList;

public class IfNode extends StatementNode {
    private ExprNode condition;
    private ArrayList<StatementNode> body;
    private ArrayList<StatementNode> elseBody;

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
