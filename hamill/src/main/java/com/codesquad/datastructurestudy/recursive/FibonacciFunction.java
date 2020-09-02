package com.codesquad.datastructurestudy.recursive;

public class FibonacciFunction {

  private static int fibonacci(int number) {

    System.out.println("func call param " + number);

    if (number == 1) {
      return 0;
    } else if (number == 2) {
      return 1;
    }

    return fibonacci(number-1) + fibonacci(number-2);
  }

  public static void main(String[] args) {
    fibonacci(7);
  }
}
