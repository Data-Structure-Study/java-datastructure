package com.codesquad.datastructurestudy.list.linkedlist.yoon;

public class LinkedList {

  private Node head;
  private Node tail;
  private int size = 0;

  private class Node {
    private Object data;
    private Node next;

    public Node(Object object) {
      this.data = object;
      this.next = null;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }
}
