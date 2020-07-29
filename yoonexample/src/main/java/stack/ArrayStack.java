package stack;

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

  }

  @Override
  public E pop() {
    return null;
  }

  @Override
  public E peek() {
    return null;
  }
}
