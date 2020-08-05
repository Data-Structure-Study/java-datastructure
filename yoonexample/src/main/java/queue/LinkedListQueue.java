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
