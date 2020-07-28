package list;

public class DummyDoublyLinkedList<E> implements List<E> {

  private int size;
  private Node<E> head;
  private Node<E> tail;

  public DummyDoublyLinkedList() { // 초기화
    this.head = new Node<>(null);
    this.tail = new Node<>(null);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  @Override
  public void insert(E data) { // tail쪽으로 데이터가 추가 됩니다.

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
    private Node<T> prev;

    public Node(T data) {
      this.data = data;
    }
  }
}
