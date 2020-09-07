package com.codesquad.datastructurestudy.stack.yoon;

public class StackCircularLinkedList {

  private Node tail;
  private int count;

  public StackCircularLinkedList() {
    this.tail = null;
  }

  public boolean isEmpty() {
    if (tail == null) {
      return true;
    }
    return false;
  }

  public void push(String data) {
    Node newNode = new Node(data);

    if (tail == null) {
      newNode.next = newNode;
      tail = newNode;
    } else {
      newNode.next = tail.next;
    }
    tail.next = newNode;

    count++;
  }

  public String pop() {
    if (tail == null) {
      System.out.println("Stack Memory Error!");
      return null;
    } else {
      Node delNode = tail.next;
      if (tail.next == tail) {
        tail = null;
      } else {
        tail.next = delNode.next;
      }
      count--;
      return delNode.data;
    }
  }

  public String peek() {
    if (tail == null) {
      System.out.println("Stack Memory Error!");
      return null;
    } else {
      return tail.next.data;
    }
  }

  private class Node {
    private String data;
    private Node next;

    public Node(String data) {
      this.data = data;
      this.next = null;
    }
  }
}
