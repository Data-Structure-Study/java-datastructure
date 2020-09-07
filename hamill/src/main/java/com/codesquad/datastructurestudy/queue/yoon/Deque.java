package com.codesquad.datastructurestudy.queue.yoon;

public interface Deque {

  boolean isEmpty();
  void addFirst(int data);
  void addLast(int data);
  int removeFirst();
  int removeLast();
  int getFirst();
  int getLast();
}
