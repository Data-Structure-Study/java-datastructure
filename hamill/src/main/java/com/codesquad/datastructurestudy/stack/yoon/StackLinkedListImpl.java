package com.codesquad.datastructurestudy.stack.yoon;

import com.codesquad.datastructurestudy.tree.yoon.BinaryTreeNode;

public class StackLinkedListImpl {

  private Node head;

  public StackLinkedListImpl() {
    this.head = null;
  }

  public boolean isEmpty() {
    if (head == null) {
      return true;
    }
    return false;
  }

  public void push(BinaryTreeNode data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public BinaryTreeNode pop() {
    BinaryTreeNode delData;
    Node delNode;

    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return null;
    }

    delData = head.data;
    delNode = head;

    head = head.next;
    delNode = null;
    return delData;
  }

  public BinaryTreeNode peek() {
    if (isEmpty()) {
      System.out.println("Stack Memory Error!");
      return null;
    }

    return head.data;
  }

  private class Node {
    private BinaryTreeNode data;
    private Node next;

    public Node(BinaryTreeNode data) {
      this.data = data;
      this.next = null;
    }

    public Node() {
      this.data = null;
      this.next = null;
    }
  }
}
