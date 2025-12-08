package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.statements.StatementNode;
import parser.statements.WhileNode;

public class CHandleWhile extends CHandleStatement {

    public static void handle(WhileNode node, CEmitter emitter) {
        emitter.emit("while (");
        CHandleExpression.handle(node.getCondition(), emitter);
        emitter.emitln(") {");
        for (StatementNode stmt : node.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }
        emitter.emitln("}");
    }

}
