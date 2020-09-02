package com.codesquad.datastructurestudy.list.linkedlist;

/**
 * This class implements a DoublyLinkedList. This is done using the classes
 * LinkedList and Link.
 *
 * A linked list is similar to an array, it holds values. However,
 * links in a linked list do not have indexes. With a linked list
 * you do not need to predetermine it's size as it grows and shrinks
 * as it is edited. This is an example of a double ended, doubly
 * linked list. Each link references the next link and the previous
 * one.
 *
 * 연결 리스트는 배열과 유사하며, 값을 가지고 있다. 그러나 연결 리스트의 링크에는
 * 인덱스가 없다. 연결 리스트를 사용하면 편집할 때 크기가 커지거나 작아지는 것을
 * 미리 파악할 필요가 없다. 이것은 이중 말단, 이중 연결 리스트의 예다. 각 링크는
 * 다음 링크와 이전 링크를 참조한다.
 *
 */

public class DoublyLinkedList {
    /**
     * Head refers to the front of the list
     * 헤드는 목록 앞쪽을 가리킨다
     */
    private Link head;

    /**
     * Tail refers to the back of the list
     * 테일은 목록 뒤쪽을 가리킨다
     */
    private Link tail;

    /**
     * Default Constructor
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Constructs a list containing the elements of the array
     * 배열의 요소를 포함하는 포함하는 리스트 구성
     *
     * @param array the array whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     *
     * array : 이 리스트에 요소를 넣을 배열
     * 만약 지정된 콜렉션이 null이면 NullPointerException을 throws 해라
     */
    public DoublyLinkedList(int[] array) {
        if (array == null) throw new NullPointerException();
        for (int i : array) {
            insertTail(i);
        }
    }

    /**
     * Insert an element at the head
     * 머리 부분에 element 삽입
     *
     * @param x Element to be inserted
     * 삽입할 element x
     */
    public void insertHead(int x) {
        Link newLink = new Link(x); // Create a new link with a value attached to it
        if (isEmpty()) // Set the first element added to be the tail
            tail = newLink;
        else
            head.previous = newLink; // newLink <-- currentHead(head)
        newLink.next = head; // newLink <--> currentHead(head)
        head = newLink; // newLink(head) <--> oldHead
    }

    /**
     * Insert an element at the tail
     *
     * @param x Element to be inserted
     *
     */
    public void insertTail(int x) {
        Link newLink = new Link(x);
        newLink.next = null; // currentTail(tail)  newLink -->
        if (isEmpty()) { // Check if there are no elements in list then it adds first element
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink; // currentTail(tail) --> newLink -->
            newLink.previous = tail; // currentTail(tail) <--> newLink -->
            tail = newLink; // oldTail <--> newLink(tail) -->
        }
    }

    /**
     * Delete the element at the head
     *
     * @return The new head
     */
    public Link deleteHead() {
        Link temp = head;
        head = head.next; // oldHead <--> 2ndElement(head)
        head.previous = null; // oldHead --> 2ndElement(head) nothing pointing at lod head so will be removed
        if (head == null)
            tail = null;
        return temp;
    }

    /**
     * Delete the element at the tail
     *
     * @return The new tail
     */
    public Link deleteTail() {
        Link temp = tail;
        tail = tail.previous; // 2ndLast(tail) <--> oldTail --> null
        tail.next = null; // 2ndLast(tail) --> null
        if (tail == null) {
            head = null;
        }
        return temp;
    }

    /**
     * Delete the element from somewhere in the list
     *
     * @param x element to be deleted
     * @return Link deleted
     */
    public void delete(int x) {
        Link current = head;

        while (current.value != x) {
            if (current != tail) {
                current = current.next;
            } else {
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }

        if (current == head)
            deleteHead();
        else if (current == tail)
            deleteTail();
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
    }

    /**
     * Inserts element and reorders
     *
     * @param x Element to be added
     */
    public void insertOrdered(int x) {
        Link newLink = new Link(x);
        Link current = head;
        while (current != null && x > current.value)
            current = current.next;

        if (current == head)
            insertHead(x);

        else if (current == null)
            insertTail(x);

        else {
            newLink.previous = current.previous;
            current.previous.next = newLink;
            newLink.next = current;

        }
    }

    /**
     * Returns true if list is empty
     * 리스트가 비어있으면 true를 반환한다
     *
     * @return true if list is empty
     *
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Prints contents of the list
     * 리스트 내용 출력
     */
    public void display() {
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
