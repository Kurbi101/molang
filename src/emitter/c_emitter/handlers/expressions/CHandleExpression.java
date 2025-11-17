package emitter.c_emitter.handlers.expressions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.CHandler;
import parser.ASTnode;
import parser.expressions.ExprNode;

public class CHandleExpression extends CHandler {

    public static void handle(ASTnode node, Emitter e) {
        ExprNode expr = (ExprNode) node;
        CEmitter emitter = (CEmitter) e;
        //TODO: ????
    }
}
