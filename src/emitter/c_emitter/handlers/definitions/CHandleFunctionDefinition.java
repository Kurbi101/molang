package emitter.c_emitter.handlers.definitions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.statements.CHandleStatement;
import parser.definitions.Argument;
import parser.definitions.FunctionDefinition;
import parser.statements.StatementNode;

import java.util.ArrayList;

import static emitter.c_emitter.handlers.CHandler.toCType;

public class CHandleFunctionDefinition extends CHandleDefinition {

    public static void handle(FunctionDefinition def, CEmitter emitter) {
        emitter.switchContext(Emitter.ContextKind.Functions);
        emitter.emit(toCType(def.getReturnType()) + " ");
        emitter.emit(def.getId() + "(");
        emitParams(def.getParams(), emitter);
        emitter.emitln(") {");
        for (StatementNode stmt : def.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }
        emitter.emitln("}");
        emitter.switchBackContext();
    }

    protected static void emitParams(ArrayList<Argument> params, CEmitter emitter) {
        for (int i = 0; i < params.size(); i++) {
            emitter.emit(toCType(params.get(i).type()) + " " + params.get(i).id());
            if (i != params.size() - 1) {
                emitter.emit(", ");
            }
        }
    }

}
