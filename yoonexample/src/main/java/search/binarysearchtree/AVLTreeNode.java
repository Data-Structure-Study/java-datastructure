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

  private BinaryTreeNode<E> rotateLL(BinaryTreeNode<E> binaryTreeNode) {
    // LL 회전을 위한 준비
    BinaryTreeNode<E> parentNode = binaryTreeNode;
    BinaryTreeNode<E> childNode = parentNode.getLeftSubTree();

    // LL 회전
    parentNode.changeLeftSubTree(childNode.getRightSubTree());
    childNode.changeRightSubTree(parentNode);

    return childNode; // 변경된 루트 노드 반환
  }

  private BinaryTreeNode<E> rotateRR(BinaryTreeNode<E> binaryTreeNode) {
    // RR 회전을 위한 준비
    BinaryTreeNode<E> parentNode = binaryTreeNode;
    BinaryTreeNode<E> childNode = parentNode.getRightSubTree();

    // RR 회전
    parentNode.changeRightSubTree(childNode.getLeftSubTree());
    childNode.changeLeftSubTree(parentNode);

    return childNode; // 변경된 루트 노드 반환
  }
}
