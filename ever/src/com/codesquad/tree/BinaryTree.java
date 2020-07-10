package com.codesquad.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {

    private BinaryTreeNode<Key, Value> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode<Key, Value> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<Key, Value> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void preOrder(BinaryTreeNode<Key, Value> node) {
        if (node != null) {
            // Node 방문
            System.out.println("Node " + node.getName() + "방문");

            // Node의 왼쪽 서브트리를 순회
            preOrder(node.getLeft());

            // Node의 오른쪽 서브트리를 순회
            preOrder(node.getRight());
        }
    }

    public void inOrder(BinaryTreeNode<Key, Value> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println("Node " + node.getName() + "방문");
            inOrder(node.getRight());
        }
    }

    public void postOrder(BinaryTreeNode<Key, Value> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println("Node " + node.getName() + "방문");
        }
    }

    public void levelOrder(BinaryTreeNode<Key, Value> node) {

        // 링크드 리스트를 사용해 구현한 Queue를 사용한다
        Queue<BinaryTreeNode<Key, Value>> queue = new LinkedList<>();

        BinaryTreeNode<Key, Value> currentNode;

        queue.add(root);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            System.out.println("Node " + node.getName() + "방문");

            if (currentNode.getLeft() != null)
                queue.add(currentNode.getLeft());

            if (currentNode.getRight() != null)
                queue.add(currentNode.getRight());
        }
    }

    public int size(BinaryTreeNode<Key, Value> node) {

        // node를 루트로 하는 서브 트리에 있는 노드 수
        return node == null ? 0 : 1 + size(node.getLeft()) + size(node.getRight());
    }

    public int height(BinaryTreeNode<Key, Value> node) {

        // node를 루트로 하는 서브트리의 높이
        return node == null ? 0 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public boolean isEqual(BinaryTreeNode<Key, Value> nodeA, BinaryTreeNode<Key, Value> nodeB) {

        // 둘 중 하나라도 null 일 경우
        if (nodeA == null || nodeB == null)
            return nodeA == nodeB;

        // 둘 다 null이 아니면 item을 비교한다
        if (nodeA.getId().compareTo(nodeB.getId()) != 0)
            return false;

        // item이 같으면 왼쪽/오른쪽 자식으로 재귀호출
        return (isEqual(nodeA.getLeft(), nodeB.getLeft()) && isEqual(nodeA.getRight(), nodeB.getRight()));
    }
}
