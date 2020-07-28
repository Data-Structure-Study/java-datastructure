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
    if (o == null) {
      Node<E> cur = this.head.next;

      while (cur.next != null) {
        if (cur.data == null) {
          return true;
        }
        cur = cur.next;
      }

      return false;
    } else {
      Node<E> cur = this.head.next;

      while (cur.next != null) {
        if (o.equals(cur.data)) {
          return true;
        }
        cur = cur.next;
      }

      return false;
    }
  }

  @Override
  public E get(int index) {
    if (isEmpty()) {
      return null;
    }

    Node<E> cur;

    // 절반을 나눠서 가까운 부분에서 접근하도록 합니다.
    if (index < (this.size / 2) + 1) { // 중간 값보다 작은 경우 앞에서부터 탐색합니다.
      cur = this.head.next;

      for (int i = 0; i < index; i++) {
        if (cur.next == null) {
          return null;
        }
        cur = cur.next;
      }
    } else {
      cur = this.tail;
      int reversedIndex = this.size - index;

      for (int i = 0; i < reversedIndex; i++) {
        if (cur.prev == null) {
          return null;
        }
        cur = cur.prev;
      }
    }

    return cur.data;
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
