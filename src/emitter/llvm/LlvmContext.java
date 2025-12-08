package emitter.llvm;

import emitter.Context;
import emitter.Emitter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LlvmContext extends Context {
    ArrayList<String> content;
    StringBuilder currentLine;


    public LlvmContext(Emitter.ContextKind kind) {
        super(kind);
    }

    public void write(String s) {
        this.currentLine.append(s);
    }

    public void writeln(String s) {
        this.write(s);
        this.content.add(this.currentLine.toString());
        this.currentLine = new StringBuilder();
    }

    public String compile() {
        return String.join("\n", this.content);
    }
}
