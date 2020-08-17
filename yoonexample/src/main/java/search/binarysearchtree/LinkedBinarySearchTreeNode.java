package search.binarysearchtree;

import java.util.Comparator;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.LinkedBinaryTreeNode;

public class LinkedBinarySearchTreeNode<E> implements BinarySearchTreeNode<E> {

  private final BinaryTreeNode<E> node;
  private final Comparator<E> comparator;

  public LinkedBinarySearchTreeNode(E data, Comparator<E> comparator) {
    this.node = new LinkedBinaryTreeNode<>(data);
    this.comparator = comparator;
  }

  @Override
  public BinaryTreeNode<E> search(E target) {
    BinaryTreeNode<E> curNode = this.node;

    while (curNode != null) {
      E curNodeData = curNode.getData();
      if (curNodeData.equals(target)) {
        return curNode;
      } else if (comparator.compare(curNodeData, target) > 0) {
        curNode = curNode.getLeftSubTree();
      } else {
        curNode = curNode.getRightSubTree();
      }
    }

    return null;
  }

  @Override
  public void insert(E data) {
    if (data == null) {
      return;
    }

    BinaryTreeNode<E> curNode = this.node;
    BinaryTreeNode<E> parentNode = null;

    while (curNode != null) { // 저장할 위치를 찾는다.
      E curNodeData = curNode.getData();
      if (data == curNodeData) { // 중복저장 허용 안함
        return;
      }

      parentNode = curNode;
      if (comparator.compare(curNodeData, data) > 0) {
        curNode = curNode.getLeftSubTree();
      } else {
        curNode = curNode.getRightSubTree();
      }
    }

    BinaryTreeNode<E> newNode = new LinkedBinaryTreeNode<>(data);
    if (comparator.compare(parentNode.getData(), data) > 0) { // 크기를 비교해서 원하는 위치에 저장한다.
      parentNode.setLeftSubTree(newNode);
    } else {
      parentNode.setRightSubTree(newNode);
    }
  }
}
