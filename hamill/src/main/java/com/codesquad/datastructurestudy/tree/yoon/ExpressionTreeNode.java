package com.codesquad.datastructurestudy.tree.yoon;

import com.codesquad.datastructurestudy.stack.yoon.StackLinkedListImpl;

public class ExpressionTreeNode extends BinaryTreeNode implements ExpressionTree {

  public BinaryTreeNode makeExpTree(String exp) {
    StackLinkedListImpl stack = new StackLinkedListImpl();

    for (int i = 0; i < exp.length(); i++) {
      String ch = exp.substring(i,i+1);
      if (Character.isDigit(ch.charAt(0))) {
        BinaryTreeNode node = new BinaryTreeNode(Character.getNumericValue(ch.charAt(0)));
        stack.push(node);
      } else {
        BinaryTreeNode node = new BinaryTreeNode();
        BinaryTreeNode btn1 = stack.pop();
        BinaryTreeNode btn2 = stack.pop();

        node.makeRightSubTree(node, btn1);
        node.makeLeftSubTree(node, btn2);
        node.setData(ch);
        stack.push(node);
      }
    }
    return stack.pop();
  }

  public int evaluateExpTree(BinaryTreeNode btn) {

    BinaryTreeNode btn1 = btn.getLeftSubTree();
    BinaryTreeNode btn2 = btn.getRightSubTree();

    if (btn1 == null && btn2 == null) {
      return Integer.parseInt(btn.getData().toString());
    }

    int operation1 = evaluateExpTree(btn1);
    int operation2 = evaluateExpTree(btn2);

    switch (btn.getData().toString()) {
      case "+":
        return operation1 + operation2;
      case "-":
        return operation1 - operation2;
      case "*":
        return operation1 * operation2;
      case "/":
        return operation1 / operation2;
    }

    return 0;
  }

  public void showPrefixTypeExp(BinaryTreeNode btn) {
    BinaryTreeMain.preorderTraverse(btn);
  }

  public void showInfixTypeExp(BinaryTreeNode btn) {
    BinaryTreeMain.inorderTraverse(btn);
  }

  public void showPostfixTypeExp(BinaryTreeNode btn) {
    BinaryTreeMain.postorderTraverse(btn);
  }
}
