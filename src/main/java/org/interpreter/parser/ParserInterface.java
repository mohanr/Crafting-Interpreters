package org.interpreter.parser;

import org.interpreter.ExpressionTree;

public interface ParserInterface {

    ExpressionTree.Expression parseExpression(String tokens);
}
