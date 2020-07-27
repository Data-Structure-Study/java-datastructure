package list;

public class CircularLinkedList<E> implements List<E> {

  private Node<E> tail;
  private int size;

  @Override
  public void insert(E data) { // 의도는 tail 위치에 새로운 노드를 추가하는 것입니다.
    Node<E> newNode = new Node<>(data);
    if (tail == null) {
      tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = tail.next; // 새로 추가될 노드의 다음 노드가 기존의 첫번째 노드여야 합니다.
      tail.next = newNode; // 마지막 노드의 다음 노드가 새로 추가될 노드여야 합니다.
      tail = newNode; // 마지막 노드는 새로 추가된 노드여야 합니다.
    }
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
