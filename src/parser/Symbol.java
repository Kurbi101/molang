package parser;

public record Symbol(int id) {
    private static int counter = 0;

    public Symbol() {
        this(counter++);
    }

    public int getID() {
        return id;
    }
}
