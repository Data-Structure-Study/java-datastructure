package com.codesquad.datastructurestudy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    // 노드를 추가합니다
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // 노드를 순회하면서 추가합니다.
    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if ( value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    // 트리가 비어있는지 확인합니다.
    public boolean isEmpty() {
        return root == null;
    }

    // 트리 사이즈를 확인합니다.
    public int getSize() {
        return getSizeRecursive(root);
    }

    // 트리 사이즈를 확인하기 위해서 레벨을 1씩 증가시키며 트리를 순회합니다
    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    // 트리 중 다음 value를 가지고 있는지 확인합니다
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    // 트리 중 다음 value를 가지고 있는지 트리를 순회하면서 확인합니다
    private boolean containsNodeRecursive(Node current, int value) {

        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    // 트리의 중위 순회 알고리즘
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    // 트리의 전위 순회 알고리즘
    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // 트리의 후위 순회 알고리즘
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    // 트리의 level-order 순회 알고리즘
    // 같은 레벨에 있는 노드를 큐에 담아서 순회하는 알고리즘
    // 큐에서 꺼내지면 자식 노드의 유무에 따라 큐에 추가된다.
    // 아직 다음 코드를 제대로 이해하지 못했으므로 수정할 예정
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.println(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    private void visit(int value) {
        System.out.println(" " + value);
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

}
