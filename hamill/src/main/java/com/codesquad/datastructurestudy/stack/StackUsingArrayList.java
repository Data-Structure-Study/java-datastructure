package com.codesquad.datastructurestudy.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    List<Integer> stackList;

    StackUsingArrayList() {
        stackList = new ArrayList<>();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (!isEmpty()) {
            int popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return popValue;
        } else {
            System.out.println("The stack is already empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        if (stackList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        return stackList.get(stackList.size() - 1);
    }
}
