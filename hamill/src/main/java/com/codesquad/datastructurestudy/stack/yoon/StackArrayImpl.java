package com.codesquad.datastructurestudy.stack.yoon;

public class StackArrayImpl implements Stack {

  private int[] stackArr;
  private int topIndex;

  public StackArrayImpl() {
    this.stackArr = new int[10];
    this.topIndex = -1;
  }

  public boolean isEmpty() {
    if (topIndex == -1) {
      return true;
    }
    return false;
  }

  public void push(int data) {
    stackArr[++topIndex] = data;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return -1;
    }
    return stackArr[topIndex--];
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return -1;
    }
    return stackArr[topIndex];
  }
}
