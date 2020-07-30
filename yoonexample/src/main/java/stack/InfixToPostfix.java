package stack;

import java.util.Arrays;

public class InfixToPostfix {

  public char[] convertInputToCharArray(String input) {
    return input.replace(" ", "").toCharArray();
  }

  public char[] convertInfixToPostfix(char[] infixCharArray) {
    Stack<Character> stack = new ListStack<>();
    char[] postfixCharArray = new char[infixCharArray.length];

    int idx = 0;
    for (char tok : infixCharArray) {
      if (Character.isDigit(tok)) { // tok이 숫자인지 확인
        postfixCharArray[idx++] = tok; // 숫자형이면 그대로 넣고, idx값을 증가시킨다.
      } else { // 연산자라면
        switch (tok) {
          case '(': // 여는 괄호라면
            stack.push(tok); // 스택에 넣는다.
            break;
          case ')': // 닫는 괄호라면
            while (true) { // 계속해서
              char popOp = stack.pop(); // 스택에서 연산자를 꺼낸다.
              if (popOp == '(') { // 연산자 (를 만날 때까지
                break;
              }
              postfixCharArray[idx++] = popOp; // 연산자를 배열에 넣는다.
            }
            break;
          case '+':
          case '-':
          case '*':
          case '/':
            // 사칙연산자가 들어오면, 스택이 비어있는지 확인하고, 스택이 비어있지 않다면, 맨 위의 연산자와 비교해서 스택에 있는 연산자가 연산을 먼저해야한다면
            while (!stack.isEmpty() && compareOperator(stack.peek(), tok) >= 0) {
              postfixCharArray[idx++] = stack.pop(); // 스택에서 연산자를 꺼내서 배열에 넣는다.
            }
            stack.push(tok); // 스택에 연산자를 넣는다.
            break;
        }
      }
    }
    while (!stack.isEmpty()) { // 스택에 남아있는 모든 연산자를 배열에 저장한다.
      postfixCharArray[idx++] = stack.pop();
    }

    return Arrays.copyOf(postfixCharArray, idx); // 후위 연산으로 변경되면 길이가 줄어들고, 배열의 길이는 idx값과 동일하므로
  }

  public int compareOperator(char op1, char op2) {
    OperatorPriority op1Priority = OperatorPriority.getOperatorPriority(op1);
    OperatorPriority op2Priority = OperatorPriority.getOperatorPriority(op2);
    return op1Priority.getPriority() - op2Priority.getPriority();
  }
}
