package lexer.tokens.literals;

import lexer.Span;
import lexer.tokens.Token;
import lexer.tokens.TokenKind;

public class BoolLiteralToken extends Token {

    private final boolean value;

    public BoolLiteralToken(boolean value, Span span) {
        super(TokenKind.BoolLiteral, span);
        this.value = value;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "(" + this.value + ") @" + this.getSpan().toString();
    }
}
