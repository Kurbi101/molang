package lexer.tokens.literals;
import lexer.Span;
import lexer.tokens.Token;
import lexer.tokens.TokenKind;

public class IdentToken extends Token {
    private final String value;

    public IdentToken(String value, Span span) {
        super(TokenKind.Ident, span);
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getKind().toString() + "(" + this.value + ") @" + this.getSpan().toString();
    }
}
