package com.codesquad.datastructurestudy.list.linkedlist.yoon;

public class DDoublyLinkedList {

  private Node dummyNodeHead;
  private Node dummyNodeTail;
  private Node head;
  private Node tail;
  private int count;

  public DDoublyLinkedList() {
    this.dummyNodeHead = new Node(-1);
    this.dummyNodeTail = new Node(-2);

    this.dummyNodeHead.prev = null;
    this.dummyNodeHead.next = this.dummyNodeTail;

    this.dummyNodeTail.prev = dummyNodeHead;
    this.dummyNodeTail.next = null;

    this.head = this.dummyNodeHead;
    this.tail = this.dummyNodeTail;
  }

  public void add(int data) {
    Node newNode = new Node(data);
    // newNode 설정
    newNode.prev = dummyNodeTail.prev;
    newNode.next = tail;
    // newNode 이전 노드 설정
    dummyNodeTail.prev.next = newNode;
    // tail 설정
    dummyNodeTail.prev = newNode;

    count++;
  }

  public void remove() {
    if (tail.prev == head) {
      System.out.println("삭제할 노드가 없습니다");
    }
    // 꼬리에 있는 노드 삭제
    tail.prev.prev.next = tail;
    tail.prev = tail.prev.prev;
    count--;
  }

  public int size() {
    return this.count;
  }

  public static void main(String[] args) {

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
