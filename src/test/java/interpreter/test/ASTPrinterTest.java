package interpreter.test;

import org.interpreter.ExpressionTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ASTPrinterTest {

    /*
    @aww org.junit.jupiter.params.provider.MethodSource
    */
    @Test
    public void groupingTest() {
        List<BinaryOperator<ExpressionTree.Expression>> patterns =
                Arrays.asList((ExpressionTree.Expression left, ExpressionTree.Expression right) ->
                        new ExpressionTree.Add(left, right));
        patterns.forEach(p -> {
            final ExpressionTree.Expression expr = p.apply(new ExpressionTree.Const(1),
                    new ExpressionTree.Const(2));
            String message = switch (expr) {
                case ExpressionTree.Add(ExpressionTree.Expression left,ExpressionTree.Expression right) -> "Test";
                case ExpressionTree.Literal(String value) -> "Test";
                case ExpressionTree.Const(int value) -> "Test";
            };
        });
    }

    @Test
    public void deriveTest(){

    }
}
