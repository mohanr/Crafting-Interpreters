package org.interpreter;

public enum Token {

    PLUS( "+", null,1);

    private final  Object literal;
    private final String lexeme;
    private final int line;

    Token(String lexeme, Object literal, int line) {
            this.lexeme = lexeme;
            this.literal = literal;
            this.line = line;
        }

        public String toString() {
            return lexeme + " " + literal;
        }

}
