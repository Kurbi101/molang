package lexer.tokens.literals;

import lexer.tokens.Token;
import lexer.tokens.TokenKind;
import lexer.Span;

public class StrLiteralToken extends Token {
    private final String value;

    public StrLiteralToken(String value, Span span) {
        super(TokenKind.StrLiteral, span);
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "(\"" + this.value + "\") @" + this.getSpan().toString();
    }

}
