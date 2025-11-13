package lexer;

public class LexingError extends RuntimeException {
    private final static String errorColor = "\\x1b[;31m";
    private final static String colorReset = "\\e[0m\t";


    public LexingError(String message) {
        super(message);
    }

}
