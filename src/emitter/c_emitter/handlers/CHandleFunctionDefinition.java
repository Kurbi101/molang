package emitter.c_emitter.handlers;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.statements.CHandleStatement;
import parser.Symbol;
import parser.definitions.Argument;
import parser.definitions.FunctionDefinition;
import parser.statements.StatementNode;
import types.Type;

import java.util.ArrayList;

import static emitter.c_emitter.handlers.CHandler.toCType;
import static emitter.c_emitter.handlers.expressions.CHandleFunctionCall.getFnName;

public class CHandleFunctionDefinition extends CHandleDefinition {

    public static void handle(FunctionDefinition def, CEmitter emitter) {
        emitter.switchContext(Emitter.ContextKind.Functions);
        emitter.switchToHFile();
        Type returnType = def.getReturnType();
        Symbol name = def.getId();
        var params = def.getParams();

        emitter.emit(toCType(returnType) + " " + getFnName(name) + "(");
        emitParams(params, emitter);
        emitter.emit(";");

        emitter.switchBackContext();
        emitter.emit(toCType(returnType) + " " + getFnName(name) + "(");
        emitParams(params, emitter);
        emitter.emitln(" {");

        for (StatementNode stmt : def.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }

        emitter.emitln("}");

    }

    protected static void emitParams(ArrayList<Argument> params, CEmitter emitter) {
        for (int i = 0; i < params.size(); i++) {
            emitter.emit(toCType(params.get(i).type()) + " " + params.get(i).id());
            if (i != params.size() - 1) {
                emitter.emit(", ");
            }
        }
        emitter.emit(")");
    }

}
