package queue;

import exception.EmptyQueueException;

public class ArrayQueue<E> implements Queue<E> {

  private static final int INITIAL_CAPACITY = 100;

  private int front;
  private int rear;
  private int size;
  private Object[] queueArray;

  public ArrayQueue() {
    queueArray = new Object[INITIAL_CAPACITY];
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void enqueue(E data) {
    if (nextIndex(this.rear) == this.front) { // 큐가 꽉 찬 경우(this.size == 100).
      return;
    }

    this.rear = nextIndex(this.rear);
    queueArray[this.rear] = data;
    this.size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }

    this.front = nextIndex(this.front);
    this.size--;
    return (E) queueArray[this.front];
  }

  @Override
  public E peek() {
    return null;
  }

  private int nextIndex(int pos) {
    return pos == INITIAL_CAPACITY - 1 ? 0 : pos + 1;
  }
}
