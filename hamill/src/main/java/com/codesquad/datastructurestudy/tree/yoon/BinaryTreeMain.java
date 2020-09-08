package com.codesquad.datastructurestudy.tree.yoon;

public class BinaryTreeMain {

  public static void inorderTraverse(BinaryTreeNode btn) {
    if (btn == null) {
      return;
    }

    if (btn.getLeftSubTree() != null || btn.getRightSubTree() != null) {
      System.out.print("( ");
    }
      inorderTraverse(btn.getLeftSubTree());
      showIntData(btn.getData());
      inorderTraverse(btn.getRightSubTree());

    if (btn.getLeftSubTree() != null || btn.getRightSubTree() != null) {
    System.out.print(") ");
    }
  }

  public static void preorderTraverse(BinaryTreeNode btn) {
    if (btn == null) {
      return;
    }

    showIntData(btn.getData());
    preorderTraverse(btn.getLeftSubTree());
    preorderTraverse(btn.getRightSubTree());
  }

  public static void postorderTraverse(BinaryTreeNode btn) {
    if (btn == null) {
      return;
    }

    postorderTraverse(btn.getLeftSubTree());
    postorderTraverse(btn.getRightSubTree());
    showIntData(btn.getData());
  }

  public static void showIntData(Object data) {
    System.out.print(data + " ");
  }

  public static void deleteTree(BinaryTreeNode btn) {
    if (btn == null) {
      return;
    }

    System.out.println("삭제되는 값 : " + btn.getData());
    deleteTree(btn.getLeftSubTree());
    deleteTree(btn.getRightSubTree());
    btn.setData(0);
    btn = null;
  }

  public static void main(String[] args) {
    BinaryTreeNode bt1 = new BinaryTreeNode();
    BinaryTreeNode bt2 = new BinaryTreeNode();
    BinaryTreeNode bt3 = new BinaryTreeNode();
    BinaryTreeNode bt4 = new BinaryTreeNode();
    BinaryTreeNode bt5 = new BinaryTreeNode();
    BinaryTreeNode bt6 = new BinaryTreeNode();

    bt1.setData(1);
    bt2.setData(2);
    bt3.setData(3);
    bt4.setData(4);
    bt5.setData(5);
    bt6.setData(6);

    bt1.makeLeftSubTree(bt1, bt2);
    bt1.makeRightSubTree(bt1, bt3);
    bt2.makeLeftSubTree(bt2, bt4);
    bt2.makeRightSubTree(bt2, bt5);
    bt3.makeRightSubTree(bt3, bt6);

    //1
    System.out.println("bt1의 왼쪽 자식 노드의 데이터 출력 : " + bt1.getLeftSubTree().getData());
    System.out.println("bt2의 왼쪽 자식 노드의 왼쪽 자식 노드의 데이터 출력 : "
        + bt2.getLeftSubTree().getData());

    //2
//    inorderTraverse(bt1);

    //3
    preorderTraverse(bt1);
    System.out.println();
    inorderTraverse(bt1);
    System.out.println();
    postorderTraverse(bt1);
    System.out.println();

    //4
    deleteTree(bt1);
    System.out.println(bt1.getLeftSubTree().getData());
    System.out.println(bt1.getRightSubTree().getData());
  }
}
