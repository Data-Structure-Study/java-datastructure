package queue;

import exception.EmptyQueueException;

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
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    E retData = this.front.data;
    this.front = this.front.next;
    this.size--;

    return retData;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }

    return this.front.data;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
