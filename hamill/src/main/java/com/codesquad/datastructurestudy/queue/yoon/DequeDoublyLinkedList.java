package com.codesquad.datastructurestudy.queue.yoon;

import java.awt.print.Pageable;

public class DequeDoublyLinkedList implements Deque{

  private Node head;
  private Node tail;

  public DequeDoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty() {
    if (head == null || tail == null) {
      return true;
    }
    return false;
  }

  public void addFirst(int data) {
    Node newNode = new Node(data);

    if (isEmpty()) {
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
    }
    head = newNode;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);

    if (isEmpty()) {
      head = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
    }
    tail = newNode;
  }

  public int removeFirst() {
    Node delNode = head;

    if (isEmpty()) {
      System.out.println("Deque Memory Error!");
      return -1;
    } else {
      delNode.prev = null;
      head = delNode.next;
      return delNode.data;
    }
  }

  public int removeLast() {
    Node delNode = tail;

    if (isEmpty()) {
      System.out.println("Deque Memory Error!");
      return -1;
    } else {
      delNode.next = null;
      tail = delNode.prev;
      return delNode.data;
    }
  }

  public int getFirst() {
    if (isEmpty()) {
      return -1;
    } else {
      return head.data;
    }
  }

  public int getLast() {
    if (isEmpty()) {
      return -1;
    } else {
      return tail.data;
    }
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
