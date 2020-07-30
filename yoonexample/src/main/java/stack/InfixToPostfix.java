package stack;

public class InfixToPostfix {

  public char[] convertInputToCharArray(String input) {
    return null;
  }

  public char[] convertInfixToPostfix(char[] input) {
    return null;
  }

  public int compareOperator(char op1, char op2) {
    OperatorPriority op1Priority = OperatorPriority.getOperatorPriority(op1);
    OperatorPriority op2Priority = OperatorPriority.getOperatorPriority(op2);
    return op1Priority.getPriority() - op2Priority.getPriority();
  }
}
