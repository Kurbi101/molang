package lexer;

public class LexingError extends RuntimeException {
    private final static String errorColor = "\\x1b[;31m";
    private final static String colorReset = "\\e[0m\t";

    private LexingError(String message) {super(message);}

    public static LexingError unexpectedCharacter(char c, String file, int line, int col) {
        String errorLine = file.split("\n")[line];
        String errorLineWithPointer = errorLine + "\n" + "".repeat(col) + "^";
        return new LexingError("Unexpected character: " + errorColor + c + colorReset + "\n" + errorLineWithPointer);

    }


}
