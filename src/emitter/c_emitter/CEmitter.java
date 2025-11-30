package emitter.c_emitter;

import emitter.Emitter;
import emitter.c_emitter.contexts.CContext;
import emitter.c_emitter.contexts.CStructContext;

import static emitter.Emitter.ContextKind.*;

public class CEmitter extends Emitter {
    private final String fileName = "output";
    private final String functionOut = "functions";
    private final String structOut = "structs";
    private final String tuplesOut = "tuples";
    private final CContext mainContext;
    private final CContext functionContext;
    private final CContext structContext;
    private final CContext tupleContext;

    public CEmitter(String dir) {
        this.mainContext = new CContext(dir, this.fileName, Main);
        this.functionContext = new CContext(dir, this.functionOut, Functions);
        this.structContext = new CStructContext(dir, this.structOut);
        this.tupleContext = new CContext(dir, this.tuplesOut, Tuples);
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
        emit(s + "\n");
    }

    public void switchToHFile() {
        this.currentContext.push(this.structContext.getHContext());
    }

    @Override
    public void emitHeaders() {
        mainContext.writeHeader();
        functionContext.writeHeader();
        structContext.writeHeader();
    }

    @Override
    public void emitFooters() {
        mainContext.writeFooter();
        functionContext.writeFooter();
        structContext.writeFooter();
    }

    public void flush() {
        mainContext.flush();
        functionContext.flush();
        structContext.flush();
    }

}
