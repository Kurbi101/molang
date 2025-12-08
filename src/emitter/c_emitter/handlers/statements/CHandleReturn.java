package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.statements.ReturnNode;

public class CHandleReturn extends CHandleStatement {

    public static void handle(ReturnNode node, CEmitter emitter) {
        emitter.emit("return");
        if (node.getExpr() != null) {
            emitter.emit(" ");
            CHandleExpression.handle(node.getExpr(), emitter);
        }
    }
}
