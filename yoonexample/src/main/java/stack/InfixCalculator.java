package stack;

public class InfixCalculator {

  InfixToPostfix infixToPostfix = new InfixToPostfix();
  PostCalculator postCalculator = new PostCalculator();

  public int calculate(String input) {
    return postCalculator.calculate(infixToPostfix.convertInputToPostfix(input));
  }
}
