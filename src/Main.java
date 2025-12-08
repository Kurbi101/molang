import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.definitions.CHandleFunctionDefinition;
import emitter.c_emitter.handlers.statements.CHandleDeclaration;
import emitter.c_emitter.handlers.statements.CHandleStatement;
import lexer.Lexer;
import lexer.LexingError;
import lexer.tokens.Token;
import parser.Symbol;
import parser.definitions.FunctionDefinition;
import parser.expressions.BinOpNode;
import parser.expressions.ExprNode;
import parser.expressions.IndexAccessNode;
import parser.expressions.literals.ArrayLiteralNode;
import parser.expressions.literals.IdentLiteralNode;
import parser.expressions.literals.IntLiteralNode;
import parser.statements.DeclarationNode;
import parser.statements.ReturnNode;
import parser.statements.StatementNode;
import types.ArrayType;
import types.IntType;
import types.Type;
import java.util.ArrayList;
import parser.statements.IfNode;
import parser.definitions.Argument;

public class Main {
    public static void main(String[] args) {
        CEmitter emitter = new CEmitter("output.c");
        ArrayList<Argument> arguments = new ArrayList<>();
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        arguments.add(new Argument(a, new IntType()));
        arguments.add(new Argument(b, new IntType()));
        Type returnType = new IntType();
        BinOpNode binOp = new BinOpNode(new IdentLiteralNode(a, new IntType()), new IdentLiteralNode(b, new IntType()), BinOpNode.BinOp.Add);
        ReturnNode returnNode = new ReturnNode(binOp);
        ArrayList<StatementNode> body = new ArrayList<>();
        body.add(returnNode);
        FunctionDefinition functionNode = new FunctionDefinition(new Symbol("add"), returnType, arguments, body);
        CHandleFunctionDefinition.handle(functionNode, emitter);
        emitter.compile();
    }
}