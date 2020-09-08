package com.codesquad.datastructurestudy.tree.yoon;

public class BinaryTreeNode {

  private Object data;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode(Object data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public BinaryTreeNode() {
    this.left = null;
    this.right = null;
  }

  public Object getData() {
    return  this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public BinaryTreeNode getLeftSubTree() {
    return this.left;
  }

  public BinaryTreeNode getRightSubTree() {
    return this.right;
  }

  public void makeLeftSubTree(BinaryTreeNode main, BinaryTreeNode sub) {
    if (main.left != null) {
      main.left = null;
    }
    main.left = sub;
  }

  public void makeRightSubTree(BinaryTreeNode main, BinaryTreeNode sub) {
    if (main.right != null) {
      main.right = null;
    }
    main.right = sub;
  }
}
