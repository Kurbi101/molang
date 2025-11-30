package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import parser.statements.BreakNode;

public class CHandleBreak extends CHandleStatement {

    public static void handle(BreakNode node, CEmitter emitter) {
        emitter.emit("break;");
    }
}
