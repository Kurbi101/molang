package emitter.c_emitter.handlers.expressions;

import emitter.c_emitter.CEmitter;
import parser.expressions.ExprNode;
import parser.expressions.literals.ArrayLiteralNode;
import parser.expressions.literals.BoolLiteralNode;
import parser.expressions.literals.CharLiteralNode;
import parser.expressions.literals.FloatLiteralNode;
import parser.expressions.literals.IdentLiteralNode;
import parser.expressions.literals.IntLiteralNode;
import parser.expressions.literals.LiteralNode;
import parser.expressions.literals.StringLiteralNode;
import types.Type;

public class CHandleLiterals extends CHandleExpression  {

    public static void handleLiteral(LiteralNode node, CEmitter emitter) {
        switch (node.getLiteralKind()) {
            case Int -> handleLiteral((IntLiteralNode) node, emitter);
            case Float -> handleLiteral((FloatLiteralNode) node, emitter);
            case String -> handleLiteral((StringLiteralNode) node, emitter);
            case Bool -> handleLiteral((BoolLiteralNode) node, emitter);
            case Char -> handleLiteral((CharLiteralNode) node, emitter);
            case Array -> handleLiteral((ArrayLiteralNode) node, emitter);
            case Ident -> handleLiteral((IdentLiteralNode) node, emitter);
        }
    }

    private static void handleLiteral(IntLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private static void handleLiteral(FloatLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private static void handleLiteral(StringLiteralNode node, CEmitter emitter) {
        emitter.emit("__cstr(" + node.getValue() + ")");
    }

    private static void handleLiteral(BoolLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private static void handleLiteral(CharLiteralNode node, CEmitter emitter) {
        emitter.emit("'" + node.getValue() + "'");
    }

    private static void handleLiteral(IdentLiteralNode node, CEmitter emitter) {
        emitter.emit(node.getSymbol().getID());
    }

    private static void handleLiteral(ArrayLiteralNode node, CEmitter emitter) {
        Type internal = node.getInternalType();
        emitter.emit("(" + toCType(internal) + "[]){");
        for (int i = 0; i < node.getValues().size(); i++) {
            CHandleExpression.handle(node.getValues().get(i), emitter);
            if (i != node.getValues().size() - 1) {
                emitter.emit(",");
            }
        }
        emitter.emit("}");
    }

}
