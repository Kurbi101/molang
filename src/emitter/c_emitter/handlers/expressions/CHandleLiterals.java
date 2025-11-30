package emitter.c_emitter.handlers.expressions;

import emitter.c_emitter.CEmitter;
import parser.expressions.ExprNode;
import parser.expressions.literals.ArrayLiteralNode;
import parser.expressions.literals.BoolLiteralNode;
import parser.expressions.literals.CharLiteralNode;
import parser.expressions.literals.FloatLiteralNode;
import parser.expressions.literals.IntLiteralNode;
import parser.expressions.literals.LiteralNode;
import parser.expressions.literals.StringLiteralNode;
import types.Type;

public class CHandleLiterals extends CHandleExpression  {

    public void handleLiteral(LiteralNode node, CEmitter emitter) {
        switch (node.getLiteralKind()) {
            case Int -> handleLiteral((IntLiteralNode) node, emitter);
            case Float -> handleLiteral((FloatLiteralNode) node, emitter);
            case String -> handleLiteral((StringLiteralNode) node, emitter);
            case Bool -> handleLiteral((BoolLiteralNode) node, emitter);
            case Char -> handleLiteral((CharLiteralNode) node, emitter);
            case Array -> handleLiteral((ArrayLiteralNode) node, emitter);
        }
    }

    private void handleLiteral(IntLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private void handleLiteral(FloatLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private void handleLiteral(StringLiteralNode node, CEmitter emitter) {
        emitter.emit("__cstr(" + node.getValue() + ")");
    }

    private void handleLiteral(BoolLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    private void handleLiteral(CharLiteralNode node, CEmitter emitter) {
        emitter.emit("'" + node.getValue() + "'");
    }

    private void handleLiteral(ArrayLiteralNode node, CEmitter emitter) {
        Type internal = node.getInternalType();
        emitter.emit("(" + toCType(internal) + "[]){");
        for (ExprNode val : node.getValues()) {
            CHandleExpression.handle(val, emitter);
            emitter.emit(",");
        }
        emitter.emit("}");
    }

}
