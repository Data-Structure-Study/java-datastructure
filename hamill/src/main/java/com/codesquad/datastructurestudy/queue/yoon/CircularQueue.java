package com.codesquad.datastructurestudy.queue.yoon;

public class CircularQueue implements Queue {

  private int front;
  private int rear;
  public int QUEUE_LENGTH = 100;
  private int[] queueArr;

  public CircularQueue() {
    this.front = 0;
    this.rear = 0;
    this.queueArr = new int[QUEUE_LENGTH];
  }

  public boolean isEmpty() {
    if (this.front == this.rear) {
      return true;
    }
    return false;
  }

  public int nextPositionIndex(int position) {
    if (position == QUEUE_LENGTH - 1) {
      return 0;
    } else {
      return position + 1;
    }
  }

  public void enqueue(int data) {
    if (nextPositionIndex(this.rear) == this.front) {
      System.out.println("Queue Memory Error!");
      return;
    }

    this.rear = nextPositionIndex(rear);
    this.queueArr[this.rear] = data;
  }

  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue Memory Error!");
      return -1;
    }

    this.front = nextPositionIndex(front);
    return queueArr[front];
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return -1;
    }

    return queueArr[nextPositionIndex(front)];
  }
}
