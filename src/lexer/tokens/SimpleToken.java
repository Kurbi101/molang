package lexer.tokens;

import lexer.Span;

public class SimpleToken extends Token {

    public SimpleToken(TokenKind kind, Span span) {
        super(kind, span);
    }

}
