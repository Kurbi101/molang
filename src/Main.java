import lexer.Lexer;
import lexer.LexingError;
import lexer.tokens.Token;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("test.txt");
        try {
            ArrayList<Token> tokens = lexer.lex();
            for (Token t: tokens) {
                System.out.println(t);
            }
        } catch (LexingError e) {
            System.out.println(e.getMessage());
        }
    }
}