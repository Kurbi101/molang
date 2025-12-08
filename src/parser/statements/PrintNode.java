package parser.statements;

import parser.expressions.ExprNode;
import parser.expressions.literals.StringLiteralNode;
import java.util.ArrayList;

public class PrintNode extends StatementNode {

    private final ArrayList<ExprNode> args;

    public PrintNode(ArrayList<ExprNode> args) {
        super(StatementKind.Print);
        this.args = args;
    }

    public ArrayList<ExprNode> getArgs() {
        return this.args;
    }
}