package emitter.c_emitter.handlers.expressions;

import emitter.c_emitter.CEmitter;
import parser.expressions.IndexAccessNode;

public class CHandleIndexAccess extends CHandleExpression {

    public static void handle(IndexAccessNode node, CEmitter emitter) {
        CHandleExpression.handle(node.getCallee(), emitter);
        emitter.emit("[");
        CHandleExpression.handle(node.getIndex(), emitter);
        emitter.emit("]");
    }
}
