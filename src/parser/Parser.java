package parser;
import java.util.ArrayList;
import java.util.HashMap;

import lexer.tokens.Token;
import lexer.tokens.TokenKind;

import java.util.Stack;

public class Parser {
    private final ArrayList<Token> tokens;
    private final HashMap<String, Symbol> symbols;
    private final Stack<Scope> scopes;
    private final String sourceFile;

    private int pos;

    public Parser(ArrayList<Token> tokens, String sourceFile) {
        this.tokens = tokens;
        this.symbols = new HashMap<>();
        this.scopes = new Stack<>();
        this.scopes.add(new Scope(null));
        this.pos = 0;
        this.sourceFile = sourceFile;
    }

    /* PARSING FUNCTIONS */

    public Token currentToken() {
        return tokens.get(pos);
    }

    public Token consumeToken() {
        return tokens.get(pos++);
    }

    public Token peekNextToken() {
        return tokens.get(pos + 1);
    }

    public Token expectConsume(TokenKind kind) {
        if (currentToken().isNot(kind)) {
            throw ParsingError.unexpectedToken(currentToken(), kind, this.sourceFile);
        }
        return consumeToken();
    }



}