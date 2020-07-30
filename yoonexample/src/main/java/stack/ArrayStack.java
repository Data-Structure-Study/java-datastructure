package stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

  private static final int INITIAL_CAPACITY = 100;

  private int topIndex;
  private Object[] arr;

  public ArrayStack() {
    this.topIndex = -1;
    this.arr = new Object[INITIAL_CAPACITY];
  }

  @Override
  public int size() {
    return this.topIndex + 1;
  }

  @Override
  public boolean isEmpty() {
    return this.topIndex == -1;
  }

  @Override
  public void push(E data) {
    this.topIndex++;
    arr[topIndex] = data;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    this.topIndex--;
    return (E) arr[topIndex + 1];
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return (E) arr[topIndex];
  }
}
