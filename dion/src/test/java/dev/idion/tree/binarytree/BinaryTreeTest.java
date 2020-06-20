package dev.idion.tree.binarytree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    @DisplayName("binaryTree root node insert test")
    void binaryTreeRootNodeInsertTest() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Node<Integer> root = binaryTree.insertNode(binaryTree.getRoot(), 1);

        Assertions.assertThat(binaryTree.getRoot()).isEqualTo(root);
    }

    @Test
    @DisplayName("root node insertions test")
    void rootNodeInsertionsTest() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Node<Integer> node1 = binaryTree.insertNode(null, 1);
        Node<Integer> node2 = binaryTree.insertNode(node1, 6);
        Node<Integer> node3 = binaryTree.insertNode(node2, 3);
        Node<Integer> node4 = binaryTree.insertNode(node3, 7);
        Node<Integer> node5 = binaryTree.insertNode(node4, 9);

        // Root Node 검증
        Assertions.assertThat(binaryTree.getRoot()).isEqualTo(node1);
        Assertions.assertThat(binaryTree.getRoot().getLeft()).isNull();
        Assertions.assertThat(binaryTree.getRoot().getRight().getData()).isEqualTo(6);

        // Root Node Right Node 검증
        Assertions.assertThat(binaryTree.getRoot().getRight().getLeft().getData()).isEqualTo(3);
        Assertions.assertThat(binaryTree.getRoot().getRight().getLeft().getLeft()).isNull();
        Assertions.assertThat(binaryTree.getRoot().getRight().getLeft().getRight()).isNull();

        Assertions.assertThat(binaryTree.getRoot().getRight().getRight().getData()).isEqualTo(7);
        Assertions.assertThat(binaryTree.getRoot().getRight().getRight().getLeft()).isNull();

        Assertions.assertThat(binaryTree.getRoot().getRight().getRight().getRight().getData()).isEqualTo(9);
        Assertions.assertThat(binaryTree.getRoot().getRight().getRight().getRight().getLeft()).isNull();
        Assertions.assertThat(binaryTree.getRoot().getRight().getRight().getRight().getRight()).isNull();

        binaryTree.preOrder();
        System.out.println();
        binaryTree.inOrder();
        System.out.println();
        binaryTree.postOrder();
    }
}
