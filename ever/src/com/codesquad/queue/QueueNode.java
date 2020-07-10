package com.codesquad.queue;

public class QueueNode<E> {

    private QueueNode<E> nextNode;

    private E item;

    public QueueNode(QueueNode<E> nextNode, E item) {
        this.nextNode = nextNode;
        this.item = item;
    }

    public void setNextNode(QueueNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public QueueNode<E> getNextNode() {
        return nextNode;
    }

    public E getItem() {
        return item;
    }
}
