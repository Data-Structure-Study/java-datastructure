package dev.idion.list.linkedlist.doubly;

/**
 * Doubly Linked List 구현체
 * @author dion
 * @version 1.0.0
 */
public class DoublyLinkedList {
    /**
     * head node
     */
    private Node head;
    /**
     * tail node
     */
    private Node tail;
    /**
     * List의 원소 수
     */
    private int size;

    /**
     * 기본 생성자
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 리스트가 비어있는지 반환
     *
     * @return 비어있다면 true / 비어있지 않다면 false 반환
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 리스트에 있는 node의 개수를 반환
     *
     * @return 리스트의 node 개수
     */
    public int size() {
        return size;
    }

    /**
     * head node 위치에 node를 추가합니다.
     *
     * @param x 추가될 node에 들어갈 value
     */
    public void insertHead(int x) {
        Node newNode = new Node(x); // 새로운 Node
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * tail node 위치에 node를 추가합니다.
     * add로도 쓸 수 있습니다.
     *
     * @param x 추가될 node에 들어갈 value
     */
    public void insertTail(int x) {
        Node newNode = new Node(x); // 새로운 Node
        newNode.next = null;
        if (isEmpty()) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Node를 추가합니다.
     *
     * @param x 추가될 node에 들어갈 value
     */
    public void add(int x) {
        insertTail(x);
    }

    /**
     * head node를 제거합니다.
     *
     * @return 제거된 node
     */
    public Node deleteHead() {
        Node temp = head;
        head = head.next;
        head.previous = null; // temp와의 연결을 끊음
        System.out.println(head);
        if (head == null) {
            tail = null;
        }
        size--;
        return temp;
    }

    /**
     * tail node를 제거합니다.
     *
     * @return 제거한 node
     */
    public Node deleteTail() {
        Node temp = tail;
        tail = tail.previous;
        tail.next = null;
        if (tail == null) {
            head = null;
        }
        size--;
        return temp;
    }

    /**
     * node를 제거합니다.
     *
     * @param node 제거할 node
     */
    public void delete(Node node) {
        Node current = head;

        while (current.value != node.value) {
            if (current != tail) {
                current = current.next;
            } else {
                throw new RuntimeException("그 노드는 없는데요?");
            }
        }

        if (current == head) {
            deleteHead();
        } else if (current == tail) {
            deleteTail();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
    }

    /**
     * 리스트를 출력합니다.
     */
    public void display() {
        Node current = head;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Doubly Linked List의 Node 구현체
 * @author dion
 * @version 1.0.0
 */
class Node {
    public int value;
    public Node next;
    public Node previous;

    /**
     * Node 생성자
     *
     * @param value Node의 값
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * Node를 보여줍니다.
     */
    public void displayNode() {
        System.out.print(value + " ");
    }

    /**
     * Main Method
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.insertTail(11);
        myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

        myList.deleteTail();
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.delete(new Node(7));
        myList.display(); // <-- 10(head) <--> 13(tail) -->

        myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
    }
}
