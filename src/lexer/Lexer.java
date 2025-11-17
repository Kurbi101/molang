package lexer;

import lexer.tokens.Token;
import lexer.tokens.TokenKind;
import lexer.tokens.literals.IntLiteralToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import lexer.tokens.literals.*;
import lexer.tokens.SimpleToken;

public class Lexer {
    private final Lexicon lexicon;
    private final String source;
    private int line;
    private int col;
    int pos;

    public Lexer(String stringPath) {
        this.lexicon = new Lexicon();
        Path path = Path.of(stringPath);
        try {
            this.source = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.line = this.col = this.pos = 0;
    }

    private char consume() {
        try {
            char current = this.source.charAt(this.pos++);
            this.col++;
            if (current == '\n') {
                this.line++;
                this.col = 0;
            }
            return current;
        } catch (Exception ignored) {
            return '\0';
        }
    }

    private char current() {
        try {
            return this.source.charAt(this.pos);
        } catch (Exception ignored) {
            return '\0';
        }
    }

    private char next() {
        try {
            return this.source.charAt(this.pos + 1);
        } catch (Exception ignored) {
            return '\0';
        }
    }


    private boolean skipWhitespace() {
        int posAtStart = this.pos;
        while (Character.isWhitespace(this.current())) {
            this.consume();
        }
        return posAtStart != this.pos;
    }

    private boolean skipComment() {
        if (this.current() == '/' && this.next() == '/') {
            while (this.consume() != '\n');
            return true;
        }
        return false;
    }

    private void skip() {
        while (skipComment() || skipWhitespace());
    }

    private static boolean isSymbol(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c) && c != '_' && !Character.isWhitespace(c);
    }


    private Token getToken() {
        this.skip();
        int startingCol = this.col;
        if (Character.isDigit(this.current())) {
            StringBuilder number = new StringBuilder();
            boolean isFloat = false;
            while (Character.isDigit(this.current()) || this.current() == '.') {
                if (this.current() == '.') {
                    isFloat = true;
                }
                number.append(this.consume());
            }
            if (isFloat) {
                return new FloatLiteralToken(Double.parseDouble(number.toString()), new Span(this.line, startingCol, this.col));
            } else {
                return new IntLiteralToken(Integer.parseInt(number.toString()), new Span(this.line, startingCol, this.col));
            }
        } else if (Character.isAlphabetic(this.current())) {
            StringBuilder word = new StringBuilder();
            while (Character.isAlphabetic(this.current()) || this.current() == '_' || Character.isDigit(this.current())) {
                word.append(this.consume());
            }
            TokenKind kind = this.lexicon.lookup(word.toString());
            if (kind == TokenKind.BoolLiteral) {
                return new BoolLiteralToken(Boolean.parseBoolean(word.toString()), new Span(this.line, startingCol, this.col));
            }
            return new SimpleToken(kind, new Span(this.line, startingCol, this.col));
        } else if (this.current() == '\"') {
            StringBuilder string = new StringBuilder();
            this.consume();
            while (this.current() != '\"') {
                if (this.current() == '\0') {
                    throw this.unexpectedCharacter();
                }
                string.append(this.consume());
            }
            this.consume();
            return new StrLiteralToken(string.toString(), new Span(this.line, startingCol, this.col));
        } else if (this.current() == '\'') {
            this.consume();
            char val = this.consume();
            if (consume() != '\''){
                throw this.unexpectedCharacter();
            }
            return new CharLiteralToken(val, new Span(this.line, startingCol, this.col));
        }
        else if (isSymbol(this.current())) {
            char first = this.consume();
            TokenKind kind = this.lexicon.charSymbolLookup(first);
            if (kind == null) {
                String symbols = Character.toString(first) + Character.toString(consume());
                try {
                    return new SimpleToken(this.lexicon.wideSymbolLookup(symbols), new Span(this.line, startingCol, this.col));
                } catch (Exception e) {
                    throw this.unexpectedCharacter();
                }
            }
            return new SimpleToken(kind, new Span(this.line, startingCol, this.col));
        } else {
           throw this.unexpectedCharacter();
        }
    }

    private LexingError unexpectedCharacter() {
        throw LexingError.unexpectedCharacter(this.current(), this.source, this.line, this.col);
    }

    public ArrayList<Token> lex() {
        ArrayList<Token> tokens = new ArrayList<>();
        while (this.current() != '\0') {
            tokens.add(this.getToken());
        }
        return tokens;
    }
}
