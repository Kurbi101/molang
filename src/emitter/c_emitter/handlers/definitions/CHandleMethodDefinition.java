package emitter.c_emitter.handlers.definitions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.statements.CHandleStatement;
import parser.definitions.MethodDefinition;
import parser.statements.StatementNode;

import static emitter.c_emitter.handlers.CHandler.toCType;

public class CHandleMethodDefinition extends CHandleFunctionDefinition {

    public static void handle(MethodDefinition def, CEmitter emitter) {
        emitter.switchContext(Emitter.ContextKind.Functions);

        emitter.emit(toCType(def.getReturnType()) + " " + getMethodName(def) + "(");
        emitter.emit(def.getCaller().getID() + "* self, ");
        emitParams(def.getParams(), emitter);
        emitter.emitln(") {");

        for (StatementNode stmt : def.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }

        emitter.emitln("}");

        emitter.switchBackContext();
    }

    private static String getMethodName(MethodDefinition def) {
        return def.getCaller() + "_" + def.getId();
    }
}
