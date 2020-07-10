package com.codesquad.tree;

public class BinaryTreeNode<Key extends Comparable<Key>, Value> {

    private Key id;

    private Value name;

    private BinaryTreeNode<Key, Value> left;

    private BinaryTreeNode<Key, Value> right;

    public BinaryTreeNode(Key id, Value name) {
        this.id = id;
        this.name = name;
        this.left = null;
        this.right = null;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public Value getName() {
        return name;
    }

    public void setName(Value name) {
        this.name = name;
    }

    public BinaryTreeNode<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<Key, Value> left) {
        this.left = left;
    }

    public BinaryTreeNode<Key, Value> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<Key, Value> right) {
        this.right = right;
    }
}
