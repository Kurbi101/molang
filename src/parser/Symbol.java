package parser;

public record Symbol(String id) {

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
