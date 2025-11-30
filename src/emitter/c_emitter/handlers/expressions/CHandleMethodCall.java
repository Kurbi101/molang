package emitter.c_emitter.handlers.expressions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import parser.ASTnode;
import parser.Symbol;
import parser.expressions.MethodCallNode;

public class CHandleMethodCall extends CHandleFunctionCall {

    public static void handle(MethodCallNode methodCall, CEmitter emitter) {

        emitter.emit(getMethodName(methodCall.getMethod()) + "(");
        CHandleExpression.handle(methodCall.getObject(), emitter);
        if (!methodCall.getArgs().isEmpty()) {
            emitter.emit(",");
            parseInputArgs(methodCall.getArgs(), emitter);
        }
        emitter.emit(")");
    }

    private static String getMethodName(Symbol methodName) {
        return "__method" + methodName.getID();
    }
}
