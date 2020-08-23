package search.binarysearchtree;

import java.util.Comparator;
import tree.binarytree.BinaryTreeNode;

public class AVLTreeNode<E> extends LinkedBinarySearchTreeNode<E> {

  public AVLTreeNode(E data, Comparator<E> comparator) {
    super(data, comparator);
  }

  private int getHeight(BinaryTreeNode<E> binaryTreeNode) {
    if (binaryTreeNode == null) {
      return 0;
    }
    int leftHeight = getHeight(binaryTreeNode.getLeftSubTree());
    int rightHeight = getHeight(binaryTreeNode.getRightSubTree());

    return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1; // 큰 쪽의 높이 반환
  }

  private int getEquilibriumFactor(BinaryTreeNode<E> binaryTreeNode) {
    if (binaryTreeNode == null) {
      return 0;
    }

    int leftHeight = getHeight(binaryTreeNode.getLeftSubTree());
    int rightHeight = getHeight(binaryTreeNode.getRightSubTree());

    return leftHeight - rightHeight;
  }
}
