package com.codesquad.datastructurestudy.queue.yoon;

public class LinkedBaseQueue implements Queue {

  private Node front;
  private Node rear;

  public LinkedBaseQueue() {
    this.front = null;
    this.rear = null;
  }

  public boolean isEmpty() {
    if (front == null) {
      return true;
    }
    return false;
  }

  public void enqueue(int data) {
    Node newNode = new Node(data);

    if (isEmpty()) {
      front = newNode;
    } else {
      rear.next = newNode;
    }
    rear = newNode;
  }

  public int dequeue() {
    Node delNode;

    if (isEmpty()) {
      System.out.println("Queue Memory Error!");
      return -1;
    } else {
      delNode = front;
      front = delNode.next;
      return delNode.data;
    }
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Queue Memory Error!");
      return -1;
    } else {
      return front.data;
    }
  }

  private class Node {
    private int data;
    private Node next;

    public Node() {
      this.data = 0;
      this.next = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
