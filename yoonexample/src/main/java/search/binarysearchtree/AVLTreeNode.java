package search.binarysearchtree;

import java.util.Comparator;
import tree.binarytree.BinaryTreeNode;

public class AVLTreeNode<E> extends LinkedBinarySearchTreeNode<E> {

  public AVLTreeNode(E data, Comparator<E> comparator) {
    super(data, comparator);
  }

  @Override
  public void insert(E data) {
    super.insert(data);
    rebalance();
  }

  @Override
  public BinaryTreeNode<E> remove(E target) {
    BinaryTreeNode<E> removeNode = super.remove(target);
    rebalance();
    return removeNode;
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

  private BinaryTreeNode<E> rotateLR(BinaryTreeNode<E> binaryTreeNode) {
    // LR 회전을 위한 준비
    BinaryTreeNode<E> parentNode = binaryTreeNode;
    BinaryTreeNode<E> childNode = parentNode.getLeftSubTree();

    parentNode.changeLeftSubTree(rotateRR(childNode)); // 부분적 RR회전
    return rotateLL(parentNode); // LL회전
  }

  private BinaryTreeNode<E> rotateRL(BinaryTreeNode<E> binaryTreeNode) {
    // RL 회전을 위한 준비
    BinaryTreeNode<E> parentNode = binaryTreeNode;
    BinaryTreeNode<E> childNode = parentNode.getLeftSubTree();

    parentNode.changeRightSubTree(rotateLL(childNode)); // 부분적 LL회전
    return rotateRR(parentNode); // RR회전
  }

  private void rebalance() {
    int equilibriumFactor = getEquilibriumFactor(super.node);

    if (equilibriumFactor > 1) { // LL OR LR
      if (getEquilibriumFactor(super.node.getLeftSubTree()) > 0) {
        super.node = rotateLL(super.node);
      } else {
        super.node = rotateLR(super.node);
      }
    }
    if (equilibriumFactor < -1) { // RR OR RL
      if (getEquilibriumFactor(super.node.getRightSubTree()) < 0) {
        super.node = rotateRR(super.node);
      } else {
        super.node = rotateRL(super.node);
      }
    }
  }
}
