package com.codesquad.queue;

import java.util.NoSuchElementException;

public class ListQueue<E> {

    private QueueNode<E> front;

    private QueueNode<E> rear;

    private int size;

    public ListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    // 새 item을 큐의 뒤(rear)에 삽입한다
    public void add(E item) {
        QueueNode<E> node = new QueueNode<>(null, item);

        if (isEmpty())
            front = node;
        else
            rear.setNextNode(node);
        rear = node;
        size++;

        System.out.println(toString());
    }

    // item을 큐의 앞(front)에서 삭제한다
    public E remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        E frontItem = front.getItem();

        this.front = this.front.getNextNode();

        size--;

        if (isEmpty())
            rear = null;

        System.out.println(toString());

        return frontItem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (isEmpty())
            return "큐가 비어있음";

        QueueNode<E> current = this.front;

        while (current != null) {
            stringBuilder.append(current.getItem()).append(" ");
            current =current.getNextNode();
        }

        return stringBuilder.toString();
    }
}
