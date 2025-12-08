package emitter.c_emitter.handlers.statements;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.expressions.CHandleExpression;
import parser.expressions.ExprNode;
import parser.statements.PrintNode;
import types.Type;
import types.TypeKind;


public class CHandlePrint extends CHandleStatement {

    public static void handle(PrintNode node, CEmitter emitter) {
        var args = node.getArgs();

        emitter.emit("printf(\"");

        for (ExprNode arg : args) {
            emitter.emit(getFlag(arg.evaluateType()) + " ");
        }

        emitter.emitln("\n, ");
        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).evaluateType().is(TypeKind.Bool)) {
                emitter.emit("(");
                CHandleExpression.handle(args.get(i), emitter);
                emitter.emit(") ? \"true\" : \"false\"");
            } else {
                CHandleExpression.handle(args.get(i), emitter);
            }
            if (i < args.size() - 1) {
                emitter.emit(", ");
            }
        }
        emitter.emitln(");");
    }

    private static String getFlag(Type type) {
        return switch (type.getKind()) {
            case Int -> "%d";
            case Float -> "%f";
            case Bool -> "%s";
            case Str -> "%s";
            case Char -> "%c";
            case Void -> "";
            case Array -> "%s";
            case Struct -> "%s";
            default -> "";
        };
    }
}
