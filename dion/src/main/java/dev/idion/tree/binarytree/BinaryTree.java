package dev.idion.tree.binarytree;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public Node<E> insertNode(Node<E> node, E data) {
        if (node == null) {
            node = new Node<>(data);
            return node;
        }
        if (node.data.compareTo(data) < 0) {
            node.right = insertNode(node.right, data);
        } else {
            node.left = insertNode(node.left, data);
        }
        return node;
    }

    private static class Node<T extends Comparable<T>> {

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
}
