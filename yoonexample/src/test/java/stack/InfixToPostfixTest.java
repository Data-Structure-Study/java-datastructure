package stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InfixToPostfixTest {

  InfixToPostfix infixToPostfix;

  @BeforeEach
  void setUp() {
    infixToPostfix = new InfixToPostfix();
  }

  @Test
  @DisplayName("입력된 정보를 배열로 만드는지 테스트")
  void 입력된_정보를_배열로_만드는지_테스트() {
    String input = "1 + 2 * 3";
    char[] expected = {'1', '+', '2', '*', '3'};
    char[] actual = infixToPostfix.convertInputToCharArray(input);

    assertThat(actual).isNotEmpty().hasSameSizeAs(expected).containsExactly(expected);
  }

  @Test
  @DisplayName("중위 표기법 배열을 후위 표기법으로 바꾸는 함수 테스트1")
  void 중위_표기법_배열을_후위_표기법으로_바꾸는_함수_테스트1() {
    char[] input = {'1', '+', '2', '*', '3'}; // 123*+
    char[] expected = {'1', '2', '3', '*', '+'};
    char[] actual = infixToPostfix.convertInfixToPostfix(input);

    assertThat(actual).isNotEmpty().hasSameSizeAs(expected).containsExactly(expected);
  }

  @Test
  @DisplayName("중위 표기법 배열을 후위 표기법으로 바꾸는 함수 테스트2")
  void 중위_표기법_배열을_후위_표기법으로_바꾸는_함수_테스트2() {
    char[] input = {'(', '1', '*', '2', '+', '3', ')', '/', '4'}; // 12*3+4/
    char[] expected = {'1', '2', '*', '3', '+', '4', '/'};
    char[] actual = infixToPostfix.convertInfixToPostfix(input);

    assertThat(actual).isNotEmpty().hasSameSizeAs(expected).containsExactly(expected);
  }

  @Test
  @DisplayName("연산자의 연산 우선순위 정보를 반환하는 함수테스트")
  void 연산자의_연산_우선순위_정보를_반환하는_함수_테스트() {
    char multiplicationSign = '*';
    char divisionSign = '/';
    char plusSign = '+';
    char minusSign = '-';
    char openingParenthesis = '(';
    char noSign = ')';

    assertThat(infixToPostfix.getOperatorPriority(multiplicationSign))
        .isEqualTo(OperatorPriority.TOP);
    assertThat(infixToPostfix.getOperatorPriority(divisionSign)).isEqualTo(OperatorPriority.TOP);
    assertThat(infixToPostfix.getOperatorPriority(plusSign)).isEqualTo(OperatorPriority.MID);
    assertThat(infixToPostfix.getOperatorPriority(minusSign)).isEqualTo(OperatorPriority.MID);
    assertThat(infixToPostfix.getOperatorPriority(openingParenthesis))
        .isEqualTo(OperatorPriority.BOT);
    assertThat(infixToPostfix.getOperatorPriority(noSign)).isEqualTo(OperatorPriority.NONE);
  }

  @Test
  @DisplayName("연산자의 우선순위 정보를 바탕으로 그 결과를 반환하는 함수 테스트1")
  void 연산자의_우선순위_정보를_바탕으로_그_결과를_반환하는_함수_테스트1() {
    char op1 = '*';
    char op2 = '+';

    assertThat(infixToPostfix.compareOperator(op1, op2)).isEqualTo(1);
  }

  @Test
  @DisplayName("연산자의 우선순위 정보를 바탕으로 그 결과를 반환하는 함수 테스트2")
  void 연산자의_우선순위_정보를_바탕으로_그_결과를_반환하는_함수_테스트2() {
    char op1 = '-';
    char op2 = '+';

    assertThat(infixToPostfix.compareOperator(op1, op2)).isEqualTo(0);
  }

  @Test
  @DisplayName("연산자의 우선순위 정보를 바탕으로 그 결과를 반환하는 함수 테스트3")
  void 연산자의_우선순위_정보를_바탕으로_그_결과를_반환하는_함수_테스트3() {
    char op1 = '(';
    char op2 = '+';

    assertThat(infixToPostfix.compareOperator(op1, op2)).isEqualTo(-1);
  }
}
