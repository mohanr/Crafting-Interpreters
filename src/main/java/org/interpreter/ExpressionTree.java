package org.interpreter;

public class ExpressionTree{
     sealed public interface Expression permits Add, Const, Literal {

    }

    public record Add(Expression left, Expression right) implements Expression {
        static Token t = Token.PLUS;
    }

    public record Const(int value) implements  Expression {
    }

    public record Literal(String value) implements  Expression {
    }
}

