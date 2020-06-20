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
}
