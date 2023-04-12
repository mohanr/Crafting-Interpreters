package org.interpreter;

import java.util.Arrays;

public enum Token {

    expression( "expression", null,1),
    factor( "factor", null,1),
    comparison( "comparison", null,1),
    unary( "unary", null,1),
    term( "term", null,1),
    primary( "primary", null,1),
    equality( "equality", null,1),

    PLUS( "+", null,1),
    LEFT_PAREN( "(", null,1),
    RIGHT_PAREN( ")", null,1),
    LEFT_BRACE( "{", null,1),
    RIGHT_BRACE( "}", null,1),
    COMMA( ",", null,1),
    DOT( ".", null,1),
    MINUS( "-", null,1),
    SEMICOLON( ";", null,1),
    SLASH( "/", null,1),
    RIGHT_PAREN_STAR( ")*", null,1),
    STAR( "*", null,1),
    // One or two character tokens.
    BANG( "!", null,1),
    BANG_EQUAL( "!=", null,1),
    EQUAL( "=", null,1),
    EQUAL_EQUAL( "==", null,1),
    GREATER( ">", null,1),
    GREATER_EQUAL( ">=", null,1),
    LESS( "<", null,1),
    LESS_EQUAL( "<=", null,1),
    PIPE( "|", null,1),

    // Literals.
    IDENTIFIER( "IDENTIFIER", null,1),
    STRING( "STRING", null,1),
    NUMBER( "NUMBER", null,1),

    // Keywords.
    TRUE( "true", null,1),
    FALSE( "false", null,1),

    NIL( "nil", null,1),
    EOF( "EOF", null,1);

    public final  String literal;
    public final String lexeme;
    private final int line;

    Token(String lexeme, String literal, int line) {
            this.lexeme = lexeme;
            this.literal = literal;
            this.line = line;
        }

    public static Token value(String s) {
        return Arrays.stream(Token.values()).
                filter(value -> value.lexeme.equals(s) ).findAny().get();
    }

    public String toString() {
            return lexeme + " " + literal;
        }

}
