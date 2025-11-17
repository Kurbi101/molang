package emitter;

import java.io.FileWriter;
import java.util.ArrayList;

public abstract class Context {
    private FileWriter writer;
    protected final String fileName;
    private ArrayList<String> content;
    private StringBuilder currentLine;
    private final Emitter.ContextKind kind;

    public Context(String dir, String filename, Emitter.ContextKind kind) {
        this.kind = kind;
        this.fileName = filename;
        try {
            this.writer = new FileWriter(dir + "/" + filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        writeHeader();
    }

    public void write(String s) {
        this.currentLine.append(s);
    }

    public void writeln(String s) {
        this.currentLine.append(s);
        this.content.add(this.currentLine.toString());
        this.currentLine = new StringBuilder();
    }

    public abstract void writeHeader();

    public abstract void writeFooter();

    public void flush() {
        writeHeader();

        try {
            for (String line : content) {
                writer.write(line + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        writeFooter();

        try {
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Emitter.ContextKind getKind() {
        return this.kind;
    }
}