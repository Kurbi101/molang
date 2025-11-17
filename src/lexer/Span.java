package lexer;

public record Span (int line, int colStart, int colEnd) {

    @Override
    public String toString() {
        return "[" + this.line + ", " + this.colStart + ", " + this.colEnd + "]";
    }
}
