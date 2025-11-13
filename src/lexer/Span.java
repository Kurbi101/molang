package lexer;

public record Span (int start, int end) {

    @Override
    public String toString() {
        return "[" + this.start + ", " + this.end + "]";
    }
}
