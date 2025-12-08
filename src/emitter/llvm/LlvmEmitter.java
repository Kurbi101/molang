package emitter.llvm;

import emitter.Emitter;

import java.util.stream.Collectors;


public class LlvmEmitter extends Emitter {
    private final LlvmContext typeDefs;
    private final LlvmContext functions;
    private final LlvmContext globals;
    private final LlvmContext main;


    public LlvmEmitter() {
        this.typeDefs = new LlvmContext(Emitter.ContextKind.TypeInfo);
        this.functions = new LlvmContext(Emitter.ContextKind.Functions);
        this.globals = new LlvmContext(Emitter.ContextKind.Globals);
        this.main = new LlvmContext(Emitter.ContextKind.Main);
        this.contexts.put(Emitter.ContextKind.TypeInfo, typeDefs);
        this.contexts.put(ContextKind.Functions, functions);
        this.contexts.put(ContextKind.Globals, globals);
        this.contexts.put(ContextKind.Main, main);

        initMain();
    }

    private void initMain() {
        switchContext(ContextKind.Main);
        emitln("define i32 @main(i32 %argc, i8** %argv) {");
        emitln("    entry:");
        switchBackContext();
    }


    @Override
    protected void emit(String s) {
        this.currentContext().write(s);
    }

    public void emitln(String s) {
        this.currentContext().writeln(s);
    }

    public String compile() {
        switchContext(ContextKind.Main);
        emitln("    ret i32 0");
        emitln("}");
        switchBackContext();
        return this.contexts.values().stream()
                .map((ctx -> ((LlvmContext)ctx).compile()))
                .collect(Collectors.joining("\n"));
    }
}
