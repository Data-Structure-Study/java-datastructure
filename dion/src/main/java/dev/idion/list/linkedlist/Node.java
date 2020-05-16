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
     * @param newNode 마지막 위치에 추가할 Node
     * @since 2020-05-16
     */
    public static void appendNode(Node newNode) {
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

    /**
     * 지정한 index에 있는 Node를 찾습니다.
     * @param location 찾고자 하는 index
     * @return 해당 인덱스에 위치한 Node
     * @since 2020-05-16
     */
    public static Node getNodeAt(int location) {
        Node current = Node.head;

        while (current != null && location-- > 0) {
            current = current.nextNode;
        }

        return current;
    }

    /**
     * 해당 Node를 제거합니다.
     * @param remove 제거할 Node
     * @since 2020-05-16
     */
    public static void removeNode(Node remove) {
        if (Node.head == remove) {
            Node.head = remove.nextNode;
        } else {
            Node current = Node.head;
            while (current != null && current.nextNode != remove) {
                current = current.nextNode;
            }

            if (current != null) {
                current.nextNode = remove.nextNode;
            }
        }
    }

    /**
     * 선택한 Node 다음에 새로운 Node를 집어넣습니다.
     * @param current 새로운 Node가 삽입될 이전 Node
     * @param newNode 새로운 Node
     * @since 2020-05-16
     */
    public static void insertAfter(Node current, Node newNode) {
        newNode.nextNode = current.nextNode;
        current.nextNode = newNode;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
