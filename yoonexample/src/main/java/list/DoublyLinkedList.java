package list;

public class DoublyLinkedList<E> implements List<E> {

  private Node<E> head;
  private int size;

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

  private static class Node<E> {

    private E data;
    private Node<E> prev;
    private Node<E> next;

    public Node(E data) {
      this.data = data;
    }
  }
}
