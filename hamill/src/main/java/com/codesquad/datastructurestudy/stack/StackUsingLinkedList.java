package com.codesquad.datastructurestudy.stack;

import java.util.EmptyStackException;

public class StackUsingLinkedList {

    private int length;
    private ListNode top;

    public StackUsingLinkedList() {
        length = 0;
        top = null;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.getData();
        top = top.getNext();
        length--;
        return result;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Size of stack is: " + stack.size());

        stack.pop();
        stack.pop();

        System.out.println("Top element of stack is: " + stack.peek());

    }

}
