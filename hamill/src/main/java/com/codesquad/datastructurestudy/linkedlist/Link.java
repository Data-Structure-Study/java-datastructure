package com.codesquad.datastructurestudy.linkedlist;

public class Link {
    /**
     * Value of node
     */
    public int value;
    /**
     * This points to the link in front of the new link
     */
    public Link next;
    /**
     * This points to the link behind the new link
     */
    public Link previous;

    /**
     * Constructor
     *
     * @param value Value of node
     */
    public Link(int value) {
        this.value = value;
    }

    /**
     * Displays the node
     */
    public void displayLink() {
        System.out.print(value + " ");
    }

    /**
     * Main Method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display();

        myList.insertTail(11);
        myList.display();

        myList.deleteTail();
        myList.display();

        myList.delete(7);
        myList.display();

        myList.insertOrdered(23);
        myList.insertOrdered(67);
        myList.insertOrdered(3);
        myList.display();
    }
}
