package emitter.c_emitter.contexts;

import emitter.Emitter;

public class CStructContext extends CContext {

    static private int counter = 0;

    static public int newTypeId() {
        return counter++;
    }

    public CStructContext() {
        super(Emitter.ContextKind.Structs);
    }
}
