package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.CHandleFunctionDefinition;
import emitter.c_emitter.handlers.CHandler;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.ASTnode;
import parser.expressions.ExprNode;
import parser.statements.*;
import static parser.statements.StatementNode.StatementKind.*;

public class CHandleStatement extends CHandler {

    public static void handle(StatementNode node, CEmitter emitter) {
        switch (node.getKind()) {
            case Return -> CHandleReturn.handle((ReturnNode) node, emitter);
            case Break -> CHandleBreak.handle((BreakNode) node, emitter);
            case Continue -> CHandleContinueNode.handle((ContinueNode) node, emitter);
            case Expression -> CHandleExpression.handle((ExprNode) node, emitter);
            case If -> CHandleIf.handle((IfNode) node, emitter);
            case For -> CHandleFor.handle((ForNode) node, emitter);
            case While -> CHandleWhile.handle((WhileNode) node, emitter);
            case None -> emitter.emit(";");
        }
    }
}
