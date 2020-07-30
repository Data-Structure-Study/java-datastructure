package dev.idion.tree.binarytree;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public Node<E> insertNode(Node<E> node, E data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        if (node == null) {
            node = new Node<>(data);
            return node;
        }
        if (node.getData().compareTo(data) < 0) {
            node.setRight(insertNode(node.getRight(), data));
        } else {
            node.setLeft(insertNode(node.getLeft(), data));
        }
        return node;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    private void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData());
            inOrder(node.getRight());
        }
    }

    private void postOrder(Node<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData());
        }
    }
}
