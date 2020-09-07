package com.codesquad.datastructurestudy.queue.yoon;

public class DequeMain {

  public static void main(String[] args) {
    DequeDoublyLinkedList deque = new DequeDoublyLinkedList();

    System.out.println("데이터 넣기 1차");
    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);

    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);

    System.out.println("데이터 꺼내기 1차");
    while (!deque.isEmpty()) {
      System.out.println(deque.removeFirst());
    }

    System.out.println("데이터 넣기 2차");
    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);

    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);

    System.out.println("데이터 꺼내기 2차");
    while(!deque.isEmpty()) {
      System.out.println(deque.removeLast());
    }
  }
}
