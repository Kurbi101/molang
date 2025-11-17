package emitter.c_emitter;

import emitter.Emitter;

import static emitter.Emitter.ContextKind.*;

public class CEmitter extends Emitter {
    private final String fileName = "output";
    private final String functionOut = "functions";
    private final String structOut = "structs";
    private final CContext mainContext;
    private final CContext functionContext;
    private final CContext structContext;

    public CEmitter(String dir) {
        this.mainContext = new CContext(dir, this.fileName, Main);
        this.functionContext = new CContext(dir, this.functionOut, Functions);
        this.structContext = new CContext(dir, this.structOut, Structs);
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
        }
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
