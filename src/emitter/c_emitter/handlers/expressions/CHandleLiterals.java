package emitter.c_emitter.handlers.expressions;

import emitter.c_emitter.CEmitter;
import parser.expressions.ExprNode;
import parser.expressions.literals.ArrayLiteralNode;
import parser.expressions.literals.BoolLiteralNode;
import parser.expressions.literals.CharLiteralNode;
import parser.expressions.literals.FloatLiteralNode;
import parser.expressions.literals.IntLiteralNode;
import parser.expressions.literals.StringLiteralNode;
import types.Type;

public class CHandleLiterals extends CHandleExpression  {

    public void handleLiteral(IntLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    public void handleLiteral(FloatLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    public void handleLiteral(StringLiteralNode node, CEmitter emitter) {
        emitter.emit("__cstr(" + node.getValue() + ")");
    }

    public void handleLiteral(BoolLiteralNode node, CEmitter emitter) {
        emitter.emit("" + node.getValue());
    }

    public void handleLiteral(CharLiteralNode node, CEmitter emitter) {
        emitter.emit("'" + node.getValue() + "'");
    }

    public void handleLiteral(ArrayLiteralNode node, CEmitter emitter) {
        Type internal = node.getInternalType();
        emitter.emit("(" + this.toCType(internal) + "){");
        for (ExprNode val : node.getValues()) {
            CHandleExpression.handle(val, emitter);
            emitter.emit(",");
        }
        emitter.emit("}");
    }

}
