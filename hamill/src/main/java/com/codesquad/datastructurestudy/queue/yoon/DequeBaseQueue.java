package com.codesquad.datastructurestudy.queue.yoon;

public class DequeBaseQueue {

  private Node head;
  private Node tail;
  private DequeDoublyLinkedList deque = new DequeDoublyLinkedList();

  public DequeBaseQueue() {
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty() {
    return deque.isEmpty();
  }

  public void enqueue(int data) {
    deque.addLast(data);
  }

  public int dequeue() {
    return deque.removeFirst();
  }

  public int peek() {
    return deque.getFirst();
  }

  private class Node {
    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    public Node() {
      this.data = 0;
      this.next = null;
      this.prev = null;
    }
  }
}
