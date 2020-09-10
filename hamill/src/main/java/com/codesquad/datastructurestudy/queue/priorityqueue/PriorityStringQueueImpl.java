package com.codesquad.datastructurestudy.queue.priorityqueue;

public class PriorityStringQueueImpl {

  HeapStringImpl heap;

  public PriorityStringQueueImpl() {
    heap = new HeapStringImpl();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public void enqueue(String data) {
    heap.insert(data);
  }

  public String dequeue() {
    return heap.delete();
  }
}
