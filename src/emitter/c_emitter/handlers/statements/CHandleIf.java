package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.statements.IfNode;
import parser.statements.StatementNode;

public class CHandleIf extends StatementNode {

    public static void handle(IfNode node, CEmitter emitter) {

        emitter.emit("if (");
        CHandleExpression.handle(node.getCondition(), emitter);
        emitter.emitln(") {");

        for (StatementNode stmt : node.getBody()) {
            CHandleStatement.handle(stmt, emitter);
        }

        emitter.emitln("}");

        var elseBody = node.getElseBody();
        if (elseBody != null) {
            emitter.emitln("else {");
            for (StatementNode stmt : elseBody) {
                CHandleStatement.handle(stmt, emitter);
            }
            emitter.emitln("}");
        }
    }

}
