package search.binarysearchtree;

import java.util.Comparator;

public class AVLTreeNode<E> extends LinkedBinarySearchTreeNode<E> {

  public AVLTreeNode(E data, Comparator<E> comparator) {
    super(data, comparator);
  }
}
