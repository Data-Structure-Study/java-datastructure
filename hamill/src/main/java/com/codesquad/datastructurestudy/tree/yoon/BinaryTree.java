package com.codesquad.datastructurestudy.tree.yoon;

public interface BinaryTree {
  int getData();
  void setData(int data);
  BinaryTreeNode getLeftSubTree();
  BinaryTreeNode getRightSubTree();
  void makeLeftSubTree(BinaryTreeNode main, BinaryTreeNode sub);
  void makeRightSubTree(BinaryTreeNode main, BinaryTreeNode sub);
}
