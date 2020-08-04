package queue;

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

  }

  @Override
  public E dequeue() {
    return null;
  }

  @Override
  public E peek() {
    return null;
  }
}
