package parser.expressions.literals;

import parser.expressions.ExprNode;

public abstract class LiteralNode extends ExprNode {

    public enum LiteralKind {
        Int,
        Float,
        String,
        Bool,
        Char,
        Array,
        Ident
    }

    public LiteralNode(LiteralKind kind) {
        this.kind = kind;
        this.exprKind = ExprKind.Literal;
    }

    private final LiteralKind kind;

    public LiteralKind getLiteralKind() {
        return kind;
    }
}
