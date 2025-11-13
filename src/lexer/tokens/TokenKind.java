package lexer.tokens;

public enum TokenKind {

    /* LITERALS*/
    IntLiteral(TokenCategory.Literal),
    FloatLiteral(TokenCategory.Literal),
    StrLiteral(TokenCategory.Literal),
    CharLiteral(TokenCategory.Literal),
    BoolLiteral(TokenCategory.Literal),
    Ident(TokenCategory.Literal),

    /* TYPES */
    TypeInt(TokenCategory.Type),
    TypeFloat(TokenCategory.Type),
    TypeStr(TokenCategory.Type),
    TypeChar(TokenCategory.Type),
    TypeBool(TokenCategory.Type),
    TypeVoid(TokenCategory.Type),

    /* Keywords */
    If(TokenCategory.Keyword),
    Else(TokenCategory.Keyword),
    While(TokenCategory.Keyword),
    For(TokenCategory.Keyword),
    Return(TokenCategory.Keyword),
    Fn(TokenCategory.Keyword),
    Continue(TokenCategory.Keyword),
    Break(TokenCategory.Keyword),
    Let(TokenCategory.Keyword),
    Var(TokenCategory.Keyword),
    Print(TokenCategory.Keyword),

    /* OPERATORS */
    Plus(TokenCategory.Operator),
    Minus(TokenCategory.Operator),
    Mul(TokenCategory.Operator),
    Div(TokenCategory.Operator),
    Mod(TokenCategory.Operator),
    Assign(TokenCategory.Operator),
    Equals(TokenCategory.Operator),
    Greater(TokenCategory.Operator),
    Less(TokenCategory.Operator),
    GreaterOrEqual(TokenCategory.Operator),
    LessOrEqual(TokenCategory.Operator),
    NotEqual(TokenCategory.Operator),

    OpenParen(TokenCategory.Symbol),
    CloseParen(TokenCategory.Symbol),
    OpenBrace(TokenCategory.Symbol),
    CloseBrace(TokenCategory.Symbol),
    OpenBracket(TokenCategory.Symbol),
    CloseBracket(TokenCategory.Symbol),
    Comma(TokenCategory.Symbol),
    Semicolon(TokenCategory.Symbol),
    Colon(TokenCategory.Symbol),
    Dot(TokenCategory.Symbol),
    Arrow(TokenCategory.Symbol);

    private final TokenCategory category;

    private TokenKind(TokenCategory category) {
        this.category = category;
    }

    public TokenCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public String toSymbol() {
        return switch (this) {
            case Plus -> "+";
            case Minus ->  "-";
            case Mul -> "*";
            case Div -> "/";
            case Mod -> "%";
            case Assign -> "=";
            case Equals -> "==";
            case Greater -> ">";
            case Less -> "<";
            case GreaterOrEqual -> ">=";
            case LessOrEqual -> "<=";
            case NotEqual -> "!=";
            case OpenParen -> "(";
            case CloseParen -> ")";
            case OpenBrace -> "{";
            case CloseBrace -> "}";
            case OpenBracket -> "[";
            case CloseBracket -> "]";
            case Comma -> ",";
            case Semicolon -> ";";
            case Colon -> ":";
            case Dot -> ".";
            case Arrow -> "->";
            default -> throw new IllegalArgumentException("Invalid symbol: " + this);
        };
    }
}
