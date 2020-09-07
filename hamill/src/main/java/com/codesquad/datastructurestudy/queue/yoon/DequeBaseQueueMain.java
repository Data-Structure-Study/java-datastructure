package com.codesquad.datastructurestudy.queue.yoon;

public class DequeBaseQueueMain {

  public static void main(String[] args) {
    DequeBaseQueue queue = new DequeBaseQueue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    while (!queue.isEmpty()) {
      System.out.println(queue.dequeue());
    }
  }
}
