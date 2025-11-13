package lexer.tokens.literals;

import lexer.Span;
import lexer.tokens.Token;
import lexer.tokens.TokenKind;


public class FloatLiteralToken extends Token {
    private final double value;

    public FloatLiteralToken(double value, Span span) {
        super(TokenKind.FloatLiteral, span);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "(" + this.value + ") @" + this.getSpan().toString();
    }

}
