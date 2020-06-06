package com.codesquad.datastructurestudy.stack;

public class FixedSizeArrayStack {
    protected int capacity;

    public static final int CAPACITY = 16;

    protected int[] stackArray;

    protected int top = -1;

    public FixedSizeArrayStack() {
        this(CAPACITY);
    }

    public FixedSizeArrayStack(int cap) {
        this.capacity = cap;
        this.stackArray = new int[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == capacity) {
            throw new Exception("Stack is full.");
        }
        stackArray[++top] = data;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stackArray[top];
    }

    public int pop() throws Exception {
        int data;
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        data = stackArray[top];
        stackArray[top--] = Integer.MIN_VALUE;
        return data;
    }

    public static void main(String[] args) throws Exception {
        FixedSizeArrayStack myStack = new FixedSizeArrayStack(2);
        myStack.push(5);
        myStack.push(8);

        System.out.println("*********************Fixed Stack Array Implementation*********************");
        System.out.println("Size of stack : " + myStack.size());
        System.out.println("Pop element from Stack : " + myStack.pop());
        System.out.println("Pop element from Stack : " + myStack.pop());
        System.out.println("Pop element from Stack : " + myStack.pop());
    }
}
