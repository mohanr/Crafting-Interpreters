package interpreter.test;

import org.interpreter.Token;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ParserTest {

    @Test
    public void parserTest(){
        final List<Token> tokens =
                Arrays.stream("""
                expression equality
                comparison term
                unary primary → equality ;
                → comparison ( ( != | == ) comparison )* ; 
                → term ( ( > | >= | < | <= ) term )* ;
                → factor ( ( - | + ) factor )* ;
                → unary ( ( / | * ) unary )* ;
                → ( ! | - ) unary
                | primary ;
                → NUMBER | STRING | true | false | nil | ( expression ) ;""".split("\\s+"))
                 .filter(s -> !s.equals("→") && !s.equals(";")).map(s ->Token.value(s))
                .collect(toList());
                // .forEach(System.out::println);
                //tokens.forEach(System.out::println);
    }
}
