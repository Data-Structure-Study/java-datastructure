package com.codesquad;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top;

    public class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public T pop() {
        if (this.top == null) {
            throw new EmptyStackException();
        }

        T data = this.top.data;
        this.top = this.top.next;
        return data;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return this.top.data;
    }

    public void push(T data) {
        this.top = new Node<>(data, top);
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
