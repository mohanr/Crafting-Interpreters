package interpreter.test;

import static org.interpreter.ExpressionTree.*;

import org.interpreter.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ASTPrinterTest {

    /*
    @aww org.junit.jupiter.params.provider.MethodSource
    */
    @Test
    public void literalTest() {
        StringBuilder builder = new StringBuilder();
        List<UnaryOperator<Object>> patterns =
                Arrays.asList(val ->
                        new Literal(Token.PLUS, val.toString()));
        patterns.forEach(p -> {
            final Expression expr = (Expression) p.apply("1 2 3");
            String message = switch (expr) {
                case Add(Expression left,Expression right) -> "Test";
                case Literal(Token token,String value) -> builder.append("(" +
                                                            Token.PLUS.lexeme + " " +
                                                             value + ")").toString();
                case Const(int value) -> "Test";
            };
            Assertions.assertEquals(message,"(+ 1 2 3)");

        });
    }
}
