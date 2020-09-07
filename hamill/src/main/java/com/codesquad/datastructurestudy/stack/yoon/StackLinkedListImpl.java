package com.codesquad.datastructurestudy.stack.yoon;

public class StackLinkedListImpl implements Stack{

  private Node head;

  public StackLinkedListImpl() {
    this.head = null;
  }

  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }

  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public int pop() {
    int delData;
    Node delNode;

    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return -1;
    }

    delData = head.data;
    delNode = head;

    head = head.next;
    delNode = null;
    return delData;
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return -1;
    }

    return head.data;
  }

  private class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node() {
      this.data = -1;
      this.next = null;
    }
  }
}
