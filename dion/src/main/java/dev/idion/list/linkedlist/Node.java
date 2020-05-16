package dev.idion.list.linkedlist;

/**
 * Singly Linked List 구현체
 * @author dion
 * @version 1.0.0
 */
public class Node {
    private static Node head;

    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    /**
     * Node를 맨 마지막 위치에 추가합니다.
     * @param newNode 마지막 위치에 추가할 노드
     * @since 2020-05-16
     */
    public void appendNode(Node newNode) {
        if (Node.head == null) {
            Node.head = newNode;
        } else {
            Node tail = head;
            while (tail.nextNode != null) {
                tail = tail.nextNode;
            }

            tail.nextNode = newNode;
        }
    }
}
