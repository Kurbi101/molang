package emitter.c_emitter.contexts;

import emitter.Emitter;

public class CTypeInfoContext extends CContext {
    public CTypeInfoContext(String dir, String filename) {
        super(dir, filename, Emitter.ContextKind.TypeInfo);
    }
}
