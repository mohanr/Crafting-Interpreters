package interpreter.test;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void parserTest(){
        String tokens = "expression equality\n" +
                "comparison term\n" +
                "unary primary → equality ;\n" +
                "→ comparison ( ( \"!=\" | \"==\" ) comparison )* ; → term ( ( \">\" | \">=\" | \"<\" | \"<=\" ) term )* ; → factor ( ( \"-\" | \"+\" ) factor )* ;\n" +
                "→ unary ( ( \"/\" | \"*\" ) unary )* ;\n" +
                "→ ( \"!\" | \"-\" ) unary\n" +
                "| primary ;\n" +
                "→ NUMBER | STRING | \"true\" | \"false\" | \"nil\" | \"(\" expression \")\" ;";
    }
}
