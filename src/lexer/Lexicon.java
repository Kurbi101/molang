package lexer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

import lexer.tokens.TokenCategory;
import lexer.tokens.TokenKind;

public class Lexicon {
    private final HashMap<String, TokenKind> keywords;
    private final HashMap<String, TokenKind> types;
    private final HashMap<String, TokenKind> wideSymbols;
    private final HashMap<String, TokenKind> charSymbols;
    private final HashMap<String, TokenKind> boolLiterals;

    public Lexicon() {
        this.keywords = collectKeywords();
        this.types = collectTypes();
        this.charSymbols = collectCharSymbols();
        this.wideSymbols = collectWideSymbols();
        this.boolLiterals = collectBoolLiterals();
    }

    private HashMap<String, TokenKind> collectKeywords() {
        return (HashMap<String, TokenKind>) Arrays.stream(TokenKind.values())
                .filter(t -> t.getCategory() == TokenCategory.Keyword)
                .collect(Collectors.toMap(
                        t -> t.name().toLowerCase(),
                        t -> t
                ));
    }

    private HashMap<String, TokenKind> collectTypes() {
        return (HashMap<String, TokenKind>) Arrays.stream(TokenKind.values())
                .filter(t -> t.getCategory() == TokenCategory.Type)
                .collect(Collectors.toMap(
                        t -> t.name().toLowerCase(),
                        t -> t
                ));
    }

    private HashMap<String, TokenKind> collectCharSymbols() {
        return (HashMap<String, TokenKind>) Arrays.stream(TokenKind.values())
                .filter(t -> t.getCategory() == TokenCategory.Symbol || t.getCategory() == TokenCategory.Operator)
                .filter(t -> t.toSymbol().length() == 1)
                .collect(Collectors.toMap(
                        t -> t.toSymbol().toLowerCase(),
                        t -> t
                ));
    }

    private HashMap<String, TokenKind> collectWideSymbols() {
        return (HashMap<String, TokenKind>) Arrays.stream(TokenKind.values())
                .filter(t -> t.getCategory() == TokenCategory.Symbol || t.getCategory() == TokenCategory.Operator)
                .filter(t -> t.toSymbol().length() > 1)
                .collect(Collectors.toMap(
                        t -> t.toSymbol().toLowerCase(),
                        t -> t
                ));
    }

    private HashMap<String, TokenKind> collectBoolLiterals() {
        HashMap<String, TokenKind> result = new HashMap<>();
        result.put("true", TokenKind.BoolLiteral);
        result.put("false", TokenKind.BoolLiteral);
        return result;
    }

    public TokenKind lookup(String word) {
            if (keywords.containsKey(word)) {
                return keywords.get(word);
            } else if (boolLiterals.containsKey(word)) {
                return boolLiterals.get(word);
            } else return types.getOrDefault(word, TokenKind.Ident);
    }

    public TokenKind charSymbolLookup(char c) {
        String s = Character.toString(c);
        return charSymbols.get(s);
    }

    public TokenKind wideSymbolLookup(String s) {
        return wideSymbols.get(s);
    }

}
