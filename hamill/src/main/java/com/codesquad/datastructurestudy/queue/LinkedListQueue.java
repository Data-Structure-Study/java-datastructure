package com.codesquad.datastructurestudy.queue;


import com.codesquad.datastructurestudy.linkedlist.LinkedList;

public class LinkedListQueue {
    Node front;
    Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    // Class for node
    private static class Node {
        // data
        int value;
        Node next;

        Node (int value) {
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
    public void insertLast(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            // previous last point to new node
            rear.next = newNode;
        }

        rear = newNode;
    }

    public int removeFirst() {
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

    public int nodeValue() {
        return front.value;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    /** Queue operations */
    public void insert(int item) {
        insertLast(item);
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        return removeFirst();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return nodeValue();
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.insert(3);
        linkedListQueue.insert(6);
        System.out.println("-- Displaying Queue Data --");
        linkedListQueue.displayList();
        System.out.println("Item peeked " + linkedListQueue.peek());
        System.out.println("-- Removing Queue elements --");
        System.out.println("Item removed " + linkedListQueue.remove());
        System.out.println("Item removed " + linkedListQueue.remove());
    }
}
