package org.interpreter;
import static org.interpreter.ExpressionTree.Expression;
import static org.interpreter.ExpressionTree.Add;
import static org.interpreter.ExpressionTree.Const;
import java.util.List;
import java.util.Map;



public class Evaluator {

        public static int evaluate(Expression expr, Map<String, Integer> env) {
            return switch (expr) {
                case Add(Expression left, Expression right) -> evaluate(left, env) + evaluate(right, env);
                case Const(int value) -> value;
            };
        }
    }

    class ConstantFolderPass {
        public static Expression fold(Expression expr) {
            return switch (expr) {
                case Add(Expression left, Expression right) -> new Add(fold(left), fold(right));
                case Const(int value) -> expr;
            };
        }
    }

    interface ExprRewritingPass {
        Expression rewrite(Expression expr);
    }

    class ExprRewriter {
        private List<ExprRewritingPass> passes;

        ExprRewriter(ExprRewritingPass... passes) {
            this.passes = List.of(passes);
        }

        public ExprRewriter register(ExprRewritingPass pass) {
            passes.add(pass);
            return this;
        }

        public Expression rewrite(Expression expr) {
            for (ExprRewritingPass pass : passes) {
                expr = pass.rewrite(expr);
            }
            return expr;
        }
    }


    class ConstantFoldingPass implements ExprRewritingPass {
        public Expression rewrite(Expression expr) {
            return switch (expr) {
                case Add(Expression left, Expression right) -> new Add(rewrite(left), rewrite(right));
                case Const(int value) -> expr;
            };
        }

    }
