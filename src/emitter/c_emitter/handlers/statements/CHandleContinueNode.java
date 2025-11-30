package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import parser.statements.ContinueNode;

public class CHandleContinueNode extends CHandleStatement {

    public static void handle(ContinueNode node, CEmitter emitter) {
        emitter.emit("continue;");
    }
}
