package interpreter.test;

import org.interpreter.Evaluator;
import org.interpreter.ExpressionTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;

import static org.interpreter.ExpressionTree.Expression;
import static org.interpreter.ExpressionTree.Add;

public class FoldingTestTree {

    private Evaluator evaluator;

    @Test
    void constFold() {
        List<BinaryOperator<Expression>> patterns =
                Arrays.asList((Expression left, Expression right) ->
                                                   new Add(left, right));
        patterns.forEach( p -> {
            final Expression expr = p.apply(new ExpressionTree.Const(1),
                                            new ExpressionTree.Const(2));
            Assertions.assertEquals(Evaluator.evaluate(expr, Map.of()),3);
        });
    }
}
