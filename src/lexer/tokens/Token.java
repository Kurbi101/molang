package lexer.tokens;

import lexer.Span;

public abstract class Token {
    private final TokenKind kind;
    private final Span span;

    protected Token(TokenKind kind, Span span) {
        this.kind = kind;
        this.span = span;
    }

    public Span getSpan() {
        return this.span;
    }

    public TokenKind getKind() {
        return this.kind;
    }

    public boolean is(TokenKind kind) {
        return this.kind == kind;
    }

    public boolean isNot(TokenKind kind) {
        return this.kind != kind;
    }

    @Override
    public String toString() {
        return kind.toString() + " @" + this.span.toString();
    }
}
