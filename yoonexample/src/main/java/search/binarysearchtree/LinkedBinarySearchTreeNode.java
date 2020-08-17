package search.binarysearchtree;

import tree.binarytree.BinaryTreeNode;
import tree.binarytree.LinkedBinaryTreeNode;

public class LinkedBinarySearchTreeNode<E> implements BinarySearchTreeNode<E> {

  private final BinaryTreeNode<E> node;

  public LinkedBinarySearchTreeNode(E data) {
    this.node = new LinkedBinaryTreeNode<>(data);
  }

  @Override
  public E getNodeData() {
    return node.getData();
  }

  @Override
  public BinarySearchTreeNode<E> search(E data) {
    return null;
  }

  @Override
  public void insert(E data) {

  }
}
