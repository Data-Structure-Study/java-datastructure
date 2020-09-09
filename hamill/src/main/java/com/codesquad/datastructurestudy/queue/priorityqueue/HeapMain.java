package com.codesquad.datastructurestudy.queue.priorityqueue;

public class HeapMain {

  public static void main(String[] args) {
    HeapImpl heap = new HeapImpl();

    heap.insert(100);
    heap.insert(200);
    heap.insert(300);
    System.out.println(heap.delete());

    heap.insert(100);
    heap.insert(200);
    heap.insert(300);
    System.out.println(heap.delete());

    while (!heap.isEmpty()) {
      System.out.println(heap.delete());
    }
  }
}
