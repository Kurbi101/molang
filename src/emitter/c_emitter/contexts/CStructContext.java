package emitter.c_emitter.contexts;

import emitter.Emitter;

public class CStructContext extends CContext {
    private final CContext typeInfo;

    static private int counter = 0;

    static public int newTypeId() {
        return counter++;
    }

    private void writeToTypeInfo(String s) {
        this.typeInfo.write(s);
    }

    private void writeLineToTypeInfo(String s) {
        this.typeInfo.writeln(s);
    }

    public CStructContext(String dir, String filename) {
        super(dir, filename, Emitter.ContextKind.Structs);
        typeInfo = new CContext(dir, filename, Emitter.ContextKind.TypeInfo);
    }
}
