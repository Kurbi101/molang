package emitter.c_emitter.contexts;

import emitter.Context;
import emitter.Emitter;

import java.util.ArrayList;

public class CContext extends Context {

    public CContext(Emitter.ContextKind kind) {
        super(kind);
    }

    public String compile() {
        return String.join("\n", this.content) + "\n";
    }

}
