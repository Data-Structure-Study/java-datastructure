package stack;

import java.util.EmptyStackException;
import list.CircularLinkedList;
import list.List;

public class CircularListStack<E> implements Stack<E> {

  private final List<E> list = new CircularLinkedList<>();
  private int lastIndex = -1;

  @Override
  public int size() {
    return this.list.size();
  }

  @Override
  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  @Override
  public void push(E data) {
    this.lastIndex++;
    this.list.insert(data);
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    E tmpData = this.list.remove(lastIndex);
    this.lastIndex--;
    return tmpData;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return this.list.get(lastIndex);
  }
}
