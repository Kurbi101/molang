package emitter;

import parser.ASTnode;

public interface EmitterHandler {

    public static void handle(ASTnode node, Emitter emitter) {}
}
