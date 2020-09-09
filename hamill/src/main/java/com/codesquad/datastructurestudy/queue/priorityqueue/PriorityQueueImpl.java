package com.codesquad.datastructurestudy.queue.priorityqueue;

public class PriorityQueueImpl implements PriorityQueue {

  HeapImpl heap;

  public PriorityQueueImpl() {
    heap = new HeapImpl();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public void enqueue(int data) {
    heap.insert(data);
  }

  public int dequeue() {
    return heap.delete();
  }
}
