package stack;

public class PostCalculator {

  public int calculate(char[] input) {
    Stack<Integer> stack = new ListStack<>();

    for (char tok : input) {
      if (Character.isDigit(tok)) {
        stack.push(Character.getNumericValue(tok));
      } else {
        int op2 = stack.pop();
        int op1 = stack.pop();

        switch (tok) {
          case '+':
            stack.push(op1 + op2);
            break;
          case '-':
            stack.push(op1 - op2);
            break;
          case '*':
            stack.push(op1 * op2);
            break;
          case '/':
            stack.push(op1 / op2);
            break;
        }
      }
    }

    return stack.pop();
  }
}
