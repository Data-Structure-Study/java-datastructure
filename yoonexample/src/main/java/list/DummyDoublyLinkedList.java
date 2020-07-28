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
    Node<E> newNode = new Node<>(data);

    newNode.prev = this.tail.prev; // 새로운 노드의 이전 노드는 마지막 노드입니다.
    newNode.next = this.tail; // 새로운 노드의 다음 노드는 tail입니다.
    this.tail.prev.next = newNode; // 이전 마지막 노드의 다음을 새로운 노드로 지정합니다.
    this.tail.prev = newNode; // tail 노드의 이전노드를 새로운 노드로 지정합니다.

    this.size++;
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
