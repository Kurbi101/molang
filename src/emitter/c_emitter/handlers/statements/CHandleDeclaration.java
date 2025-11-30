package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.statements.DeclarationNode;
import types.Type;

public class CHandleDeclaration extends CHandleStatement {

    public static void handle(DeclarationNode node, CEmitter emitter) {
        if (node.isConst()) {
            emitter.emit("const ");
        }

        emitter.emit(toCType(node.getType()) + " ");
        emitter.emit("var" + node.getId());
        emitter.emit(" = ");

        if (node.getValue() == null) {
            emitter.emitln(defaultValue(node.getType()) + ";");
        } else {
            CHandleExpression.handle(node.getValue(), emitter);
            emitter.emitln(";");
        }

    }

    private static String defaultValue(Type type) {
        return switch (type.getKind()) {
            case Int -> "0";
            case Float -> "0.0";
            case Str -> "__str_empty()";
            case Char -> "'\0'";
            case Bool -> "false";
            case Void -> "";
            case Array -> "{}";
            case Struct -> "NULL";
        };
    }

}
