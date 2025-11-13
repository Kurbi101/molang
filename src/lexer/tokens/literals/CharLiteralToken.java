package lexer.tokens.literals;

import lexer.tokens.TokenKind;
import lexer.tokens.Token;
import lexer.Span;

public class CharLiteralToken extends Token{

    private final char value;

    public CharLiteralToken(char value, Span span) {
        super(TokenKind.CharLiteral, span);
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "('" + this.value + "') @" + this.getSpan().toString();
    }
}
