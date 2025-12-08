package emitter.c_emitter.handlers.expressions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import parser.ASTnode;
import parser.Symbol;
import parser.expressions.ExprNode;
import parser.expressions.FunctionCallNode;

import java.util.ArrayList;

public class CHandleFunctionCall extends CHandleExpression {

    public static void handle(FunctionCallNode fnCall, CEmitter emitter) {
        String fnName = getFnName(fnCall.getId());
        emitter.emit(fnName + "(");
        parseInputArgs(fnCall.getArgs(), emitter);
        emitter.emit(")");
    }

    protected static void parseInputArgs(ArrayList<ExprNode> args, CEmitter emitter) {
        for (int i = 0; i < args.size(); i++) {
            CHandleExpression.handle(args.get(i), emitter);
            if (i != args.size()) {
                emitter.emit(",");
            }
        }
    }

    public static String getFnName(Symbol id) {
        return id.getID();
    }

}
