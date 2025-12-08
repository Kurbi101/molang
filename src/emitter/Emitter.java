package emitter;

import java.util.HashMap;
import java.util.Stack;

public abstract class Emitter {
    protected HashMap<ContextKind, Context> contexts;
    protected Stack<Context> currentContext;

    public Emitter() {
        this.contexts = new HashMap<>();
        this.currentContext = new Stack<>();
    }

    public enum ContextKind {
        Tuples,
        Main,
        Functions,
        Structs,
        TypeInfo,
        Strings,
        Globals,
    };

    protected abstract void emit(String s);

    public void emitln(String s) {
        emit(s + "\n");
    }

    public void switchContext(ContextKind context) {
        currentContext.push(contexts.get(context));
    }

    public Context currentContext() {
        return currentContext.peek();
    }

    public void switchBackContext() {
        currentContext.pop();
    }

    public void insertContext(Context context, ContextKind kind) {
        contexts.put(kind, context);
    }
}
