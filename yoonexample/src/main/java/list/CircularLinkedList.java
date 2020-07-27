package list;

public class CircularLinkedList<E> implements List<E> {

  private Node<E> tail;
  private int size;

  @Override
  public void insert(E data) { // 의도는 tail 위치에 새로운 노드를 추가하는 것입니다.
    Node<E> newNode = new Node<>(data);
    if (this.tail == null) {
      this.tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = this.tail.next; // 새로 추가될 노드의 다음 노드가 기존의 첫번째 노드여야 합니다.
      this.tail.next = newNode; // 마지막 노드의 다음 노드가 새로 추가될 노드여야 합니다.
      this.tail = newNode; // 마지막 노드는 새로 추가된 노드여야 합니다.
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
    if (this.tail == null) { // 초기화만 된 상태라면 데이터가 없으므로 false를 반환합니다.
      return false;
    }
    Node<E> cur = this.tail.next; // head를 선택합니다.
    if (o == null) {
      for (int i = 0; i < this.size; i++) { // 사이즈만큼만 순회하도록 합니다.
        if (cur.data == null) {
          return true;
        }
        cur = cur.next;
      }
    } else {
      for (int i = 0; i < this.size; i++) {
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
    if (this.tail == null) {
      return null;
    }
    Node<E> cur = this.tail.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.data;
  }

  @Override
  public E remove(int index) {
    if (this.tail == null) {
      return null;
    }
    Node<E> cur = this.tail.next;
    Node<E> prev = this.tail;

    for (int i = 0; i < index; i++) { // 삭제 대상까지 이동합니다.
      if (cur.next == null) {
        return null;
      }
      prev = cur;
      cur = cur.next;
    }

    if (cur == this.tail) { // 삭제 대상이 tail 노드라면
      if (this.tail == this.tail.next) { // 삭제 대상이 마지막 노드라면
        tail = null;
      } else {
        this.tail = prev;
      }
    }

    prev.next = cur.next; // 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 지정
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
