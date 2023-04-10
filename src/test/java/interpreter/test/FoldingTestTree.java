package interpreter.test;

import org.interpreter.Evaluator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.interpreter.ExpressionTree.*;

public class FoldingTestTree {

    private Evaluator evaluator;

    /*
    @aww org.junit.jupiter.params.provider.MethodSource
     */
    @Test
    @MethodSource
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

    /*
    @aww org.junit.jupiter.params.provider.MethodSource
     */
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
