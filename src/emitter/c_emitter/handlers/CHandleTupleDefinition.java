package emitter.c_emitter.handlers;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import parser.definitions.TupleDefinition;
import types.Type;

import java.util.stream.Collectors;

import static emitter.c_emitter.handlers.CHandler.toCType;

public class CHandleTupleDefinition extends CHandleDefinition {
    public static void handle(TupleDefinition def, CEmitter emitter) {
        emitter.switchContext(Emitter.ContextKind.Tuples);
        emitter.switchToHFile();

        emitter.emitln("typedef struct " + getTupleName(def) + "{");
        for (int i = 0; i < def.types().size(); i++) {
            emitter.emitln(def.types().get(i) + "field" + i + ";");
        }
        emitter.emitln("} " + getTupleName(def) + ";");

        emitter.switchBackContext();
        emitter.switchBackContext();
    }

    public static String getTupleName(TupleDefinition def) {
        return "__" + def.types().stream().map(CHandler::toCType).collect(Collectors.joining("_")) + "_tuple";
    }
}
