package emitter.c_emitter.handlers.expressions;

import emitter.Emitter;
import emitter.c_emitter.CEmitter;
import parser.ASTnode;
import parser.expressions.BinOpNode;
import parser.expressions.ExprNode;

public class CHandleBinOp extends CHandleExpression {
    public static void handle(BinOpNode binOp, CEmitter emitter) {

        ExprNode lhs = binOp.getLeft();
        ExprNode rhs = binOp.getRight();
        BinOpNode.BinOp op = binOp.getOp();

        emitter.emit("(" + binOp.evaluateType() + ")(");
        CHandleExpression.handle(lhs, emitter);
        emitter.emit(toCOp(op));
        CHandleExpression.handle(lhs, emitter);
        emitter.emit(")");
    }

    private static String toCOp(BinOpNode.BinOp op) {
        return switch (op) {
            case Add -> "+";
            case Sub -> "-";
            case Mul -> "*";
            case Div -> "/";
            case Mod -> "%";
            case And -> "&&";
            case Or -> "||";
            case Xor -> "^";
            case Equal -> "==";
            case Assign -> "=";
            case NotEqual -> "!=";
            case LessThan -> "<";
            case LessThanEqual -> "<=";
            case GreaterThan -> ">";
            case GreaterTHanEqual -> ">=";
            case AddAssign -> "+=";
            case SubAssign -> "-=";
            case MulAssign -> "*=";
            case DivAssign -> "/=";
            case ModAssign -> "%=";
            case AndAssign -> "&=";
            case OrAssign -> "|=";
            case XorAssign -> "^=";
            default -> throw new UnsupportedOperationException("Unsupported binary operation: " + op);
        };
    }
}
