package com.codesquad.datastructurestudy.queue.priorityqueue;

public class SimpleHeapMain {

  public static void main(String[] args) {
    SimpleHeapImpl heap = new SimpleHeapImpl();

    heap.insert(100, 1);
    heap.insert(200, 2);
    heap.insert(300, 3);
    System.out.println(heap.delete());

    heap.insert(100, 1);
    heap.insert(200, 2);
    heap.insert(300, 3);
    System.out.println(heap.delete());

    while(!heap.isEmpty()) {
      System.out.println(heap.delete());
    }
  }
}
