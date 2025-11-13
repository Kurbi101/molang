package emitter;

import java.io.FileWriter;
import java.nio.file.Path;

public abstract class Context {
    private FileWriter writer;
    private final String fileName;

    public Context(String dir, String filename) {

        this.fileName = filename;
        try {
            this.writer = new FileWriter(dir + "/" + filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        writeHeader();
    }

    public void write(String s) {
        try {
            writer.write(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeln(String s) {
        try {
            writer.write(s + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void writeHeader();

    public abstract void writeFooter();

}
