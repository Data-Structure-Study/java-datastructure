package com.codesquad.datastructurestudy.queue.priorityqueue;

public class PriorityStringQueueMain {

  public static void main(String[] args) {
    PriorityStringQueueImpl priorityStringQueue = new PriorityStringQueueImpl();

    priorityStringQueue.enqueue("1");
    priorityStringQueue.enqueue("12");
    priorityStringQueue.enqueue("123");
    System.out.println(priorityStringQueue.dequeue());

    priorityStringQueue.enqueue("1");
    priorityStringQueue.enqueue("12");
    priorityStringQueue.enqueue("123");
    System.out.println(priorityStringQueue.dequeue());

    while (!priorityStringQueue.isEmpty()) {
      System.out.println(priorityStringQueue.dequeue());
    }
  }
}
