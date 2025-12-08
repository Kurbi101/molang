package emitter.c_emitter;

import emitter.Emitter;
import emitter.c_emitter.contexts.CContext;
import emitter.c_emitter.contexts.CStructContext;

import java.io.FileWriter;

import static emitter.Emitter.ContextKind.*;

public class CEmitter extends Emitter {
    private final CContext mainContext;
    private final CContext functionContext;
    private final CContext structContext;
    private final CContext tupleContext;
    private final String out;

    public CEmitter(String out) {
        this.out = out;
        this.mainContext = new CContext(Main);
        this.functionContext = new CContext(Functions);
        this.structContext = new CStructContext();
        this.tupleContext = new CContext(Tuples);
        this.insertContext(this.mainContext, Main);
        this.insertContext(this.functionContext, Functions);
        this.insertContext(this.structContext, Structs);
        this.insertContext(this.tupleContext, Tuples);
    }

    public void emit(String s) {
        switch (currentContext.peek().getKind()) {
            case Main:
                mainContext.write(s);
                break;
            case Functions:
                functionContext.write(s);
                break;
            case Structs:
                structContext.write(s);
                break;
            case Tuples:
                tupleContext.write(s);
                break;
        }
    }

    public void emitln(String s) {
        switch (currentContext.peek().getKind()) {
            case Main:
                mainContext.writeln(s);
                break;
            case Functions:
                functionContext.writeln(s);
                break;
            case Structs:
                structContext.writeln(s);
                break;
            case Tuples:
                tupleContext.writeln(s);
                break;
        }
    }

    public void compile() {
        try (FileWriter writer = new FileWriter(this.out)) {
            writer.write(this.structContext.compile());
            writer.write(this.tupleContext.compile());
            writer.write(this.functionContext.compile());
            writer.write("int main(int argc, char *argv[]) {\n");
            writer.write(this.mainContext.compile());
            writer.write("return 0;\n}");
        } catch (Exception e) {
            System.err.println("Error writing to file: "+ out + ". " + e);
        }
    }
}
