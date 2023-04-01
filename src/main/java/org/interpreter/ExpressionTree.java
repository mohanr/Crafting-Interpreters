package org.interpreter;

public class ExpressionTree{

    sealed public interface Expression permits Add, Const {
    }

    public record Add(Expression left, Expression right) implements Expression {
    }

    public record Const(int value) implements  Expression {
    }


}

