package lexer.tokens.literals;

import lexer.tokens.Token;
import lexer.tokens.TokenKind;
import lexer.Span;

public class IntLiteralToken extends Token {
    private final int value;

    public IntLiteralToken(int value, Span span) {
        super(TokenKind.IntLiteral, span);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "(" + this.value + ") @" + this.getSpan().toString();
    }
}
