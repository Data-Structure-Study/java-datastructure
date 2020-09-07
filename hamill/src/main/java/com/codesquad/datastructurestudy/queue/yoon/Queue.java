package com.codesquad.datastructurestudy.queue.yoon;

public interface Queue {

  boolean isEmpty();
  void enqueue(int data);
  int dequeue();
  int peek();
}
