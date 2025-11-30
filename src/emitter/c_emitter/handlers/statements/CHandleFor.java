package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.statements.ForNode;
import parser.statements.StatementNode;

public class CHandleFor extends CHandleStatement {

    public static void handle(ForNode node, CEmitter emitter) {

        emitter.emit("for (");
        CHandleExpression.handle(node.getInit(), emitter);
        emitter.emit(";");
        CHandleExpression.handle(node.getCondition(), emitter);
        emitter.emit(";");
        CHandleExpression.handle(node.getUpdate(), emitter);
        emitter.emitln(") {");
        for (StatementNode stmt : node.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }
        emitter.emitln("}");
    }
}
