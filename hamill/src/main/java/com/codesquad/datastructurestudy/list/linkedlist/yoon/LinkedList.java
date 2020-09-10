package com.codesquad.datastructurestudy.list.linkedlist.yoon;

import java.util.List;

public class LinkedList {

  private Node head;
  private Node tail;
  private Node cur;
  private int size = 0;

  public void add(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
  }

  public void retrieve() {
    if (head == null) {
      System.out.println("값이 존재하지 않습니다");
    } else {
      int i = 1;
      cur = head;
      System.out.println(i + "번째 데이터 : " + cur.data);

      while (cur.next != null) {
        i++;
        cur = cur.next;
        System.out.println(i + "번째 데이터 : " + cur.data);
      }
    }
  }

  // 연결 리스트 삭제(머리에서부터)
  public void remove() {
    if (head == null) {
      System.out.println("값이 존재하지 않습니다");
    } else {
      Node delNode = head;
      Node delNextNode = head.next;

      head = delNextNode;
      delNode = null;
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    System.out.println("삭제 전 리스트");
    list.retrieve();

    list.remove();
    list.remove();

    System.out.println("삭제 후 리스트");
    list.retrieve();
  }

  private class Node {
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }
}
