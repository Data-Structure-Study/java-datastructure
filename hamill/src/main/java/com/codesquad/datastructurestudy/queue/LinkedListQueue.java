package com.codesquad.datastructurestudy.queue;

public class LinkedListQueue {
    private Node front;
    private Node rear;

    // Class for node
    private static class Node {
        // data
        private int value;
        private Node next;

        private Node (int value) {
            this.value = value;
        }

        public void displayValue() {
            System.out.println("value = " + value);
        }
    }

    /*
     * Linked list operations, keeping them separate from
     * Queue operations
     */
    private void pushLast(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            // previous last point to new node
            rear.next = newNode;
        }

        rear = newNode;
    }

    private int popFirst() {
        int temp = front.value;

        // if no node left after deleting node
        if (front.next == null) {
            rear = null;
        }

        // front starts pointing to next element
        front = front.next;
        return temp;
    }

    // Method to traverse and display all nodes
    public void displayList() {
        // Start from first node
        Node current = front;
        // loop till last node
        while (current != null) {
            current.displayValue();
            current = current.next;
        }
    }

    private int nodeValue() {
        return front.value;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    /** Queue operations */
    public void push(int item) {
        pushLast(item);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return popFirst();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return nodeValue();
    }
}
