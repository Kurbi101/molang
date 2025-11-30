package emitter.c_emitter.handlers;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import parser.Symbol;
import parser.definitions.StructDefinition;
import parser.definitions.StructField;

import static emitter.c_emitter.handlers.CHandler.toCType;

public class CHandleStructDefinition extends CHandleDefinition {

    public static void handle(StructDefinition def, CEmitter emitter) {
        emitter.switchContext(Emitter.ContextKind.Structs);
        emitter.switchToHFile();

        String structName = getStructName(def.id());

        emitter.emitln("typedef struct " + structName + " " + structName + ";");
        emitter.emitln("struct " + structName + " {");

        for (StructField field : def.fields()) {
            emitter.emitln(toCType(field.type()) + " " + getFieldName(field.id()) + ";");
        }

        emitter.emitln("};");

        emitter.switchBackContext();
    }

    private static void declareTypeInfo() {};

    private static String getFieldName(Symbol id) {
        return  id.getID();
    }

    private static String getStructName(Symbol id) {
        return id.getID();
    }
}
