package com.codesquad.datastructurestudy.stack.yoon;

public class Calculator {

  public String converterToRPNExp(String exp) {
    StackCircularLinkedList stack = new StackCircularLinkedList();
    int expLen = exp.length();
    StringBuilder converterExp = new StringBuilder("");

    int index = 0;
    char tok;
    char popOp;

    for (int i = 0; i < expLen; i++) {
      tok = exp.charAt(i);

      if (Character.isDigit(tok)) {
        converterExp.append(tok);
        index++;
      } else {
        switch (tok) {
          case '(':
            stack.push(String.valueOf(tok));
            break;
          case ')':
            while(true) {
              popOp = stack.pop().charAt(0);
              if (popOp == '(') {
                break;
              }
              converterExp.append(popOp);
              index++;
            }
            break;
          case '+': case '-':
          case '*': case '/':
            while (!stack.isEmpty() && whoPrecOperation(stack.peek().charAt(0), tok) >= 0) {
              converterExp.append(stack.pop());
              index++;
            }
            stack.push(String.valueOf(tok));
            break;
        }
      }
    }

    while (!stack.isEmpty()) {
      converterExp.append(stack.pop());
      index++;
    }
    return exp = converterExp.toString();
  }

  public int getOperationPrec(char op) {
    switch (op) {
      case '*':
      case '/':
        return 5;
      case '+':
      case '-':
        return 3;
      case '(':
        return 1;
    }
    return -1;
  }

  public int whoPrecOperation(char op1, char op2) {
    int op1Prec = getOperationPrec(op1);
    int op2Prec = getOperationPrec(op2);

    if (op1Prec > op2Prec) {
      return 1;
    } else if (op1Prec < op2Prec) {
      return -1;
    } else {
      return 0;
    }
  }

  public String evalRPNExp(String exp) {
    StackCircularLinkedList stack = new StackCircularLinkedList();
    int expLen = exp.length();
    char tok;
    int num1;
    int num2;

    for (int i = 0; i < expLen; i++) {
      tok = exp.charAt(i);
      if (Character.isDigit(tok)) {
        stack.push(String.valueOf(tok));
      } else {
        num2 = Integer.valueOf(stack.pop());
        num1 = Integer.valueOf(stack.pop());

        switch (tok) {
          case '+':
            stack.push(String.valueOf(num1 + num2));
            break;
          case '-':
            stack.push(String.valueOf(num1 - num2));
          case '*':
            stack.push(String.valueOf(num1 * num2));
            break;
          case '/':
            stack.push(String.valueOf(num1 / num2));
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    String exp1 = "1+2*3";
    String exp2 = "(1+2)*3";
    String exp3 = "((1-2)+3)*(5-2)";

    exp1 = calculator.converterToRPNExp(exp1);
    exp2 = calculator.converterToRPNExp(exp2);
    exp3 = calculator.converterToRPNExp(exp3);

    System.out.println(exp1);
    System.out.println(exp2);
    System.out.println(exp3);

    String postExp1 = "42*8+";
    String postExp2 = "123+*4/";

    System.out.printf("%s = %s\n", postExp1, calculator.evalRPNExp(postExp1));
    System.out.printf("%s = %s\n", postExp2, calculator.evalRPNExp(postExp2));

  }
}
