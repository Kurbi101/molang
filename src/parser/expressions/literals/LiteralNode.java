package parser.expressions.literals;

import parser.expressions.ExprNode;

public abstract class LiteralNode extends ExprNode {
    private static final ExprKind exprKind = ExprKind.Literal;

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
    }

    private final LiteralKind kind;

    public LiteralKind getLiteralKind() {
        return kind;
    }
}
