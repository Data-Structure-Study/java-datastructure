package com.codesquad.datastructurestudy.queue.priorityqueue;

public class PriorityQueueMain {

  public static void main(String[] args) {
    PriorityQueueImpl priorityQueue = new PriorityQueueImpl();

    priorityQueue.enqueue(100);
    priorityQueue.enqueue(200);
    priorityQueue.enqueue(300);
    System.out.println(priorityQueue.dequeue());

    priorityQueue.enqueue(100);
    priorityQueue.enqueue(200);
    priorityQueue.enqueue(300);
    System.out.println(priorityQueue.dequeue());

    while (!priorityQueue.isEmpty()) {
      System.out.println(priorityQueue.dequeue());
    }
  }
}
