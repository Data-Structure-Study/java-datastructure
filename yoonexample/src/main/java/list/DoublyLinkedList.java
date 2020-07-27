package list;

public class DoublyLinkedList<E> implements List<E> {

  private Node<E> head;
  private int size;

  @Override
  public void insert(E data) {
    Node<E> newNode = new Node<>(data);

    if (head != null) { // head가 존재한다면
      newNode.next = head; // 새로운 노드의 다음노드가 기존의 head노드
      this.head.prev = newNode; // 기존 head노드의 이전노드가 새로운 노드
    }

    this.head = newNode;
    size++;
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
    if (this.head == null) {
      return false;
    }
    Node<E> cur = this.head;
    if (o == null) {
      if (cur.data == null) {
        return true;
      }
      while (cur.next != null) {
        cur = cur.next;
        if (cur.data == null) {
          return true;
        }
      }
    } else {
      if (o.equals(cur.data)) {
        return true;
      }
      while (cur.next != null) {
        cur = cur.next;
        if (o.equals(cur.data)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public E get(int index) {
    Node<E> cur = this.head;

    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }

    return cur.data;
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
