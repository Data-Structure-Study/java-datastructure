package stack;

import java.util.EmptyStackException;

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
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Node<E> tmpNode = this.head;
    this.head = this.head.next;
    size--;
    return tmpNode.data;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return this.head.data;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
