package parser.expressions;

import parser.ASTnode;
import types.Type;

public abstract class ExprNode extends ASTnode {

    protected Type type;

    public abstract Type evaluateType();

}
