package emitter;

import java.util.HashMap;
import java.util.Stack;

public abstract class Emitter {
    HashMap<ContextKind, Context> contexts;
    protected Stack<Context> currentContext;

    public Emitter() {
        this.contexts = new HashMap<>();
        this.currentContext = new Stack<>();
    }

    // TODO: add more contexts
    public enum ContextKind {
        Main,
        Functions,
        Structs,
    };

    protected abstract void emit(String s);

    void emitln(String s) {
        emit(s + "\n");
    }

    public abstract void emitHeaders();
    public abstract  void emitFooters();

    public void switchContext(Context context) {
        currentContext.push(context);
    }

    public Context currentContext() {
        return currentContext.peek();
    }

    public void switchBackContext() {
        currentContext.pop();
    }

}
