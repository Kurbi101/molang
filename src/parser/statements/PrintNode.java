package parser.statements;

import parser.expressions.ExprNode;
import parser.expressions.literals.StringLiteralNode;

public class PrintNode extends StatementNode {
    private StringLiteralNode value;

    public PrintNode(StringLiteralNode value) {
        this.value = value;
    }

    public ExprNode getValue() {
        return this.value;
    }
}