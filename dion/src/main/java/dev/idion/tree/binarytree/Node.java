package dev.idion.tree.binarytree;

public class Node<T> {

    private final T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
