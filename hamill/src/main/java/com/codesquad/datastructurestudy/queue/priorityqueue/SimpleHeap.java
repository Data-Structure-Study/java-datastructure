package com.codesquad.datastructurestudy.queue.priorityqueue;

public interface SimpleHeap {

  boolean isEmpty();
  void insert(int data, int priority);
  int delete();
}
