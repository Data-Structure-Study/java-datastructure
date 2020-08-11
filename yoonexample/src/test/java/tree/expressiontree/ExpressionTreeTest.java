package tree.expressiontree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stack.InfixToPostfix;

class ExpressionTreeTest {

  InfixToPostfix infixToPostfix;

  @BeforeEach
  void setUp() {
    infixToPostfix = new InfixToPostfix();
  }

  @Test
  @DisplayName("수식_트리_테스트")
  void 수식_트리_테스트() {
    String infixExpression = "1 + 2";
    char[] postfixExpression = infixToPostfix.convertInputToPostfix(infixExpression);

    ExpressionTree expressionTree = new LinkedExpressionTree(postfixExpression);
    assertThat(expressionTree.evaluateTree()).isEqualTo(3);

    StringBuilder sb = new StringBuilder();
    expressionTree.prefixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("+12");

    sb = new StringBuilder();
    expressionTree.infixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("1+2");

    sb = new StringBuilder();
    expressionTree.postfixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("12+");
  }

  @Test
  @DisplayName("수식_트리_테스트2")
  void 수식_트리_테스트2() {
    String infixExpression = "1 + 2 * 7";
    char[] postfixExpression = infixToPostfix.convertInputToPostfix(infixExpression);

    ExpressionTree expressionTree = new LinkedExpressionTree(postfixExpression);
    assertThat(expressionTree.evaluateTree()).isEqualTo(15);

    StringBuilder sb = new StringBuilder();
    expressionTree.prefixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("+1*27");

    sb = new StringBuilder();
    expressionTree.infixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("1+2*7");

    sb = new StringBuilder();
    expressionTree.postfixTypeExpression(sb);
    assertThat(sb.toString()).isEqualTo("127*+");
  }
}
