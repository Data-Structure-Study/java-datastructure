package list;

import java.util.Comparator;

public class DummyLinkedList<E> implements SortedList<E> {

  private int size;
  private Node<E> head = new Node<>(null);
  private Comparator<E> comp;

  @Override
  public void setSortRule(Comparator<E> comp) {
    this.comp = comp;
  }

  @Override
  public void insert(E data) {

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
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
