package parser.expressions.literals;

import parser.ParsingError;
import parser.expressions.ExprNode;
import types.ArrayType;
import types.Type;

import java.util.ArrayList;

public class ArrayLiteralNode extends ExprNode {
    private ArrayList<ExprNode> values;
    private Type type;

    public ArrayLiteralNode(ArrayList<ExprNode> values) {
        this.values = values;
        this.type = evaluateType();
    }

    public ArrayList<ExprNode> getValues() {
        return this.values;
    }

    public Type evaluateType() {
        this.type = new ArrayType(this.values.getFirst().evaluateType(), this.values.size());
        for (ExprNode val : this.values) {
            if (val.evaluateType() != this.type) {
                throw new RuntimeException("Array literal must have the same type for all elements");
            }
        }
        return this.type;
    }

    public Type getInternalType() {
        return this.type;
    }
}
