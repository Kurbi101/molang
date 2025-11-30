package emitter.c_emitter.handlers;

import parser.Symbol;

public class CHandleDefinition {


    protected static String getVarName(Symbol id) {
        return id.getID();
    }
}
