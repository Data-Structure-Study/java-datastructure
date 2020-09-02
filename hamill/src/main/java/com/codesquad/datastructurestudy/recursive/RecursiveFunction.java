package com.codesquad.datastructurestudy.recursive;

public class RecursiveFunction {

  private static void recursive(int number) {
    if (number <= 0) {
      return;
    }
    System.out.println("Recursive call!" + number);
    recursive(number-1);
  }

  public static void main(String[] args) {
    recursive(3);
  }
}
