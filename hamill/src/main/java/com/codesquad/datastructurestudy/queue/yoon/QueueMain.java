package com.codesquad.datastructurestudy.queue.yoon;

public class QueueMain {

  public static void main(String[] args) {
//    CircularQueue queue = new CircularQueue();
    LinkedBaseQueue queue = new LinkedBaseQueue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    while (!queue.isEmpty()) {
      System.out.print(queue.dequeue() + " ");
    }
  }
}
