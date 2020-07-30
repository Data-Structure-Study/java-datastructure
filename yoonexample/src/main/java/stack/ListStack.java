package stack;

public class ListStack<E> implements Stack<E> {

  private int size;
  private Node<E> head;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void push(E data) {
    Node<E> newNode = new Node<>(data);
    newNode.next = this.head;
    this.head = newNode;
    this.size++;
  }

  @Override
  public E pop() {
    return null;
  }

  @Override
  public E peek() {
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
