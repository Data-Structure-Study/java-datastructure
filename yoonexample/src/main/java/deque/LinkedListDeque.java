package deque;

import exception.EmptyDequeException;

public class LinkedListDeque<E> implements Deque<E> {

  private int size;
  private Node<E> head;
  private Node<E> tail;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public void addFirst(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()) {
      this.tail = newNode;
    } else {
      this.head.prev = newNode;
    }

    newNode.next = this.head;
    this.head = newNode;
    this.size++;
  }

  @Override
  public void addLast(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()) {
      this.head = newNode;
    } else {
      this.tail.next = newNode;
    }

    newNode.prev = this.tail;
    this.tail = newNode;
    this.size++;
  }

  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new EmptyDequeException();
    }

    E data = this.head.data;
    this.head = this.head.next;
    this.size--;
    return data;
  }

  @Override
  public E removeLast() {
    if (isEmpty()) {
      throw new EmptyDequeException();
    }

    E data = this.tail.data;
    this.tail = this.tail.prev;
    this.size--;
    return data;
  }

  @Override
  public E getFirst() {
    if (isEmpty()) {
      throw new EmptyDequeException();
    }

    return this.head.data;
  }

  @Override
  public E getLast() {
    if (isEmpty()) {
      throw new EmptyDequeException();
    }

    return this.tail.data;
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
