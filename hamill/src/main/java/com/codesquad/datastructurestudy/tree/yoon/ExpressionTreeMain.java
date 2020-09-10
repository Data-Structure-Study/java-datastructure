package com.codesquad.datastructurestudy.tree.yoon;

public class ExpressionTreeMain {

  public static void main(String[] args) {
    String exp = "12+7*";
    ExpressionTreeNode expTreeNode = new ExpressionTreeNode();
    BinaryTreeNode bTreeNode = expTreeNode.makeExpTree(exp);

    System.out.print("전위 표기법의 수식 : ");
    BinaryTreeMain.preorderTraverse(bTreeNode);

    System.out.println();
    System.out.print("중위 표기법의 수식 : ");
    expTreeNode.showInfixTypeExp(bTreeNode);

    System.out.println();
    System.out.print("후위 표기법의 수식 : ");
    expTreeNode.showPostfixTypeExp(bTreeNode);

    System.out.println();
    System.out.println("연산의 결과 : " + expTreeNode.evaluateExpTree(bTreeNode));
  }
}
