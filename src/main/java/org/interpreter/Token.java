package org.interpreter;

public enum Token {

    PLUS( "+", null,1);

    public final  String literal;
    public final String lexeme;
    private final int line;

    Token(String lexeme, String literal, int line) {
            this.lexeme = lexeme;
            this.literal = literal;
            this.line = line;
        }
    public String toString() {
            return lexeme + " " + literal;
        }

}
