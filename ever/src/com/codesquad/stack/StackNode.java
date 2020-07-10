package com.codesquad.stack;

public class StackNode<E> {

    public StackNode<E> previousNode;

    public E item;

    public StackNode(StackNode<E> previousNode, E item) {
        this.previousNode = previousNode;
        this.item = item;
    }

    public void setNextNode(StackNode<E> previousNode) {
        this.previousNode = previousNode;
    }

    public void setItem(E item) {
        this.item = item;
    }
}
