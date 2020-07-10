package com.codesquad.stack;

import java.util.EmptyStackException;

public class ListStack<E> {

    public StackNode<E> top;

    public int size;

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.item;
    }

    public void push(E item) {
        this.top = new StackNode<>(this.top, item);
        size++;

        System.out.println(toString());
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E item = top.item;

        this.top = this.top.previousNode;

        size--;

        System.out.println(toString());

        return item;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        StackNode<E> currentNode = this.top;

        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(currentNode.item).append(" ");
            currentNode = currentNode.previousNode;
        }

        return " top > " + stringBuilder.toString();
    }
}
