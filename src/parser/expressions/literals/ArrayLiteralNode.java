package parser.expressions.literals;

import parser.ParsingError;
import parser.expressions.ExprNode;
import types.ArrayType;
import types.Type;

import java.util.ArrayList;

public class ArrayLiteralNode extends LiteralNode {
    private final ArrayList<ExprNode> values;
    private Type type;

    public ArrayLiteralNode(ArrayList<ExprNode> values) {
        super(LiteralKind.Array);
        this.values = values;
        this.type = evaluateType();
    }

    public ArrayList<ExprNode> getValues() {
        return this.values;
    }

    public Type evaluateType() {
        this.type = this.values.getFirst().evaluateType();
        return new ArrayType(this.type, new IntLiteralNode(this.values.size()));
    }

    public Type getInternalType() {
        //TODO: fix
        return this.values.getFirst().evaluateType();
    }
}
