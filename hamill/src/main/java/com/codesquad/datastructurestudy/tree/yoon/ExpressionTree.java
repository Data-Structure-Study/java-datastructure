package com.codesquad.datastructurestudy.tree.yoon;

public interface ExpressionTree {
  BinaryTreeNode makeExpTree(String exp);
  int evaluateExpTree(BinaryTreeNode btn);
  void showPrefixTypeExp(BinaryTreeNode btn);
  void showInfixTypeExp(BinaryTreeNode btn);
  void showPostfixTypeExp(BinaryTreeNode btn);
}
