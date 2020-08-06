package deque;

public class LinkedLIstDeque<E> implements Deque<E> {

  private int size;
  private Node<E> head;
  private Node<E> tail;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void addFirst(E data) {

  }

  @Override
  public void addLast(E data) {

  }

  @Override
  public E removeFirst() {
    return null;
  }

  @Override
  public E removeLast() {
    return null;
  }

  @Override
  public E getFirst() {
    return null;
  }

  @Override
  public E getLast() {
    return null;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
      this.data = data;
    }
  }
}
