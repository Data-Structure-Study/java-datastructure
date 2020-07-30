package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InfixCalculatorTest {

  InfixCalculator infixCalculator;

  @BeforeEach
  void setUp() {
    infixCalculator = new InfixCalculator();
  }

  @Test
  @DisplayName("중위_표기법으로_작성된_수식_계산_테스트1")
  void 중위_표기법으로_작성된_수식_계산_테스트1() {
    String input = "1 + 2 * 3";

    assertThat(infixCalculator.calculate(input)).isEqualTo(7);
  }

  @Test
  @DisplayName("중위_표기법으로_작성된_수식_계산_테스트2")
  void 중위_표기법으로_작성된_수식_계산_테스트2() {
    String input = "(1 + 2) * 3";

    assertThat(infixCalculator.calculate(input)).isEqualTo(9);
  }

  @Test
  @DisplayName("중위_표기법으로_작성된_수식_계산_테스트3")
  void 중위_표기법으로_작성된_수식_계산_테스트3() {
    String input = "((1 - 2) + 3) * (5 - 2)";

    assertThat(infixCalculator.calculate(input)).isEqualTo(6);
  }
}
