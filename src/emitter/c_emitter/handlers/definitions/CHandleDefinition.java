package emitter.c_emitter.handlers.definitions;

import parser.Symbol;

public class CHandleDefinition {


    protected static String getVarName(Symbol id) {
        return id.getID();
    }
}
