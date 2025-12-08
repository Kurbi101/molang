package emitter;

import java.io.FileWriter;
import java.util.ArrayList;

public abstract class Context {
    protected ArrayList<String> content;
    private StringBuilder currentLine;
    private  Emitter.ContextKind kind;

    public Context(Emitter.ContextKind kind) {
        this.kind = kind;
        this.content = new ArrayList<>();
        this.currentLine = new StringBuilder();
    }

    public void write(String s) {
        this.currentLine.append(s);
    }

    public void writeln(String s) {
        this.currentLine.append(s);
        this.content.add(this.currentLine.toString());
        this.currentLine = new StringBuilder();
    }


    public Emitter.ContextKind getKind() {
        return this.kind;
    }
}