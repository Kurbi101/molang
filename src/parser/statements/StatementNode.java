package parser.statements;


import parser.ASTnode;

public  class StatementNode extends ASTnode {
    protected StatementKind kind;

    public StatementNode(StatementKind kind) {
        this.kind = kind;
    }

    public enum StatementKind {
        None,
        Expression,
        Print,
        Declaration,
        If,
        While,
        For,
        Return,
        Break,
        Continue
    }

    public StatementKind getKind() {
        return kind;
    }
}
