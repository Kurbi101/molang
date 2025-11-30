package parser.statements;

import parser.expressions.ExprNode;
import parser.expressions.literals.StringLiteralNode;
import java.util.ArrayList;

public class PrintNode extends StatementNode {
    public static final StatementKind kind = StatementKind.Print;

    private final ArrayList<ExprNode> args;

    public PrintNode(ArrayList<ExprNode> args) {
        this.args = args;
    }

    public ArrayList<ExprNode> getArgs() {
        return this.args;
    }
}