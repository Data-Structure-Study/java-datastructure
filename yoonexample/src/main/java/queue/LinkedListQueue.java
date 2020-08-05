package queue;

public class LinkedListQueue<E> implements Queue<E> {

  private int size;
  private Node<E> front;
  private Node<E> rear;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void enqueue(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()) {
      this.front = newNode;
    } else {
      this.rear.next = newNode;
    }
    this.rear = newNode;
    this.size++;
  }

  @Override
  public E dequeue() {
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
