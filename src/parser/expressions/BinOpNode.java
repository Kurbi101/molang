package parser.expressions;

import types.Type;

public class BinOpNode extends ExprNode {

    public enum BinOp {
        Add,
        Sub,
        Mul,
        Div,
        Mod,
        And,
        Or,
        Xor,
        Equal,
        Assign,
        NotEqual,
        LessThan,
        LessThanEqual,
        GreaterThan,
        GreaterTHanEqual,
    }

    private final ExprNode left;
    private final ExprNode right;
    private final BinOp op;

    public BinOpNode(ExprNode left, ExprNode right, BinOp op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public ExprNode getLeft() {
        return this.left;
    }

    public ExprNode getRight() {
        return this.right;
    }

    public BinOp getOp() {
        return this.op;
    }

    public Type evaluateType() {
        //TODO: Mika please implement this, also add type checking.
        return null;
    }
}
