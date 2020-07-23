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
    if (this.comp == null) {
      insertToHead(data);
    } else {
      insertWithSortRule(data);
    }
  }

  // 인터페이스를 통해 제공되는 메소드가 아님!
  private void insertToHead(E data) {
    Node<E> newNode = new Node<>(data);

    newNode.next = this.head.next;
    this.head.next = newNode;

    this.size++;
  }

  // 인터페이스를 통해 제공되는 메소드가 아님!
  private void insertWithSortRule(E data) {

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
    Node<E> cur = this.head.next;
    if (o == null) {
      while (cur.next != null) {
        if (cur.data == null) {
          return true;
        }
        cur = cur.next;
      }
    } else {
      while (cur.next != null) {
        if (o.equals(cur.data)) {
          return true;
        }
        cur = cur.next;
      }
    }
    return false;
  }

  @Override
  public E get(int index) {
    Node<E> cur = this.head.next;

    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }

    return cur.data;
  }

  @Override
  public E remove(int index) {
    Node<E> before = this.head;
    Node<E> cur = before.next;

    for (int i = 0; i < index; i++) {
      before = cur;
      cur = cur.next;
    }
    before.next = cur.next;
    this.size--;

    return cur.data;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
