package stack;

import java.util.EmptyStackException;

public class SunnyStack<T> {
    private Node<T> top;

    class Node<t> {
        private final T data;
        private Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

    public T pop() {
        T popData = peek();
        top = top.nextNode;
        return popData;
    }

    public void push(T pushData) {
        Node<T> t = new Node<>(pushData);
        t.nextNode = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
