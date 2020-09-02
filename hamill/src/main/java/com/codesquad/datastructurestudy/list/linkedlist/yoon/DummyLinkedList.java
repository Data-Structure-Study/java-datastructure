package com.codesquad.datastructurestudy.list.linkedlist.yoon;


public class DummyLinkedList {

  private Node dummyNode = new Node();
  private Node head = dummyNode;
  private Node tail = dummyNode;
  private int count = 0;
  private boolean comp;
  private boolean asc;

  public DummyLinkedList(boolean isTrue) {
    this.asc = isTrue;
  }

  private int whoIsAsc(int d1, int d2) {
    if (d1 < d2) {
      return 0;
    } else {
      return 1;
    }
  }

  public void add(int data) {
    if (count == 0) {
      addFirst(data);
    } else {
      addSecond(data);
    }
  }

  private void addFirst(int data) {
    Node newNode = new Node(data);
    dummyNode.next = newNode;
    count++;
  }

  private void addSecond(int data) {
    Node newNode = new Node(data);
    Node cur = new Node();
    cur.next = dummyNode.next;
    int index = 0;

//    newNode.next = dummyNode.next;
//    dummyNode.next = newNode;
//    count++;

    if (this.asc) {
      while (dummyNode.next != null && cur.next != null && whoIsAsc(data, cur.next.data) != 0) {
        cur = cur.next;
        index++;
      }
    }

    Node node = getNode(index-1);
    if (node.next == null) {
      newNode.next = null;
      node.next = newNode;
    } else {
      newNode.next = node.next;
      node.next = newNode;
    }
    count++;
  }

  public int remove(int index) {
    Node deleteNode = getNode(index);
    Node deleteNextNode = deleteNode.next;
    Node pred = getNode(index-1);
    pred.next = deleteNextNode;
    count--;
    return deleteNode.data;
  }

  public int size() {
    return this.count;
  }

  public int get(int index) {
    Node cur = new Node();
    cur.next = dummyNode.next;
    for (int i = 0; i <= index; i++) {
      cur = cur.next;
    }
    return cur.data;
  }

  private Node getNode(int index) {
    Node cur = new Node();
    cur.next = dummyNode.next;
    for (int i = 0; i <= index; i++) {
      cur = cur.next;
    }
    return cur;
  }

  private class Node {
    private int data;
    private Node next;

    public Node() {

    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }
}
