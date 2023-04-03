package interpreter.test;

import org.interpreter.Evaluator;
import org.interpreter.ExpressionTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;
import static org.interpreter.ExpressionTree.*;
import static org.interpreter.ExpressionTree.Expression;
import static org.interpreter.ExpressionTree.Add;
import static org.interpreter.ExpressionTree.Const;

public class FoldingTestTree {

    private Evaluator evaluator;

    @Test
    void binaryConstFold() {
        List<BinaryOperator<Expression>> patterns =
                Arrays.asList((Expression left, Expression right) ->
                        new Add(left, right));
        patterns.forEach( p -> {
            final Expression expr = p.apply(new Const(1),
                                            new Const(2));
            Assertions.assertEquals(Evaluator.evaluate(expr, Map.of()),3);
        });
    }

    @Test
    void constFold() {
        List<UnaryOperator<Object>> patterns =
                Arrays.asList(val -> new Const((Integer) val));
        patterns.forEach( p -> {
            final Expression val = (Expression) p.apply(1);
            Assertions.assertEquals(Evaluator.evaluate(val, Map.of()),1);
        });
    }

}
