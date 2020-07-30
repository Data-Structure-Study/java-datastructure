package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostCalculatorTest {

  PostCalculator postCalculator;

  @BeforeEach
  void setUp() {
    postCalculator = new PostCalculator();
  }

  @Test
  @DisplayName("후위_표기법으로_작성된_수식_계산_테스트1")
  void 후위_표기법으로_작성된_수식_계산_테스트1() {
    char[] input = {'4', '2', '*', '8', '+'};

    assertThat(postCalculator.calculate(input)).isEqualTo(16);
  }

  @Test
  @DisplayName("후위_표기법으로_작성된_수식_계산_테스트2")
  void 후위_표기법으로_작성된_수식_계산_테스트2() {
    char[] input = {'1', '2', '3', '+', '*', '4', '/'};

    assertThat(postCalculator.calculate(input)).isEqualTo(1);
  }
}
