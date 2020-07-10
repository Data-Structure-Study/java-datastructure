package com.codesquad.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> {

    private E[] items;

    // 스택의 top 항목의 배열 원소 인덱스
    private int top;

    public ArrayStack() {

        // 초기에 크기가 1인 배열 생성
        this.items = (E[]) new Object[1];

        this.top = -1;
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items[top];
    }

    public void push(E item) {
        if (items.length == size()) {

            // 스택을 2배 크기로 확장
            resize(2 * items.length);
        }

        items[++this.top] = item;

        System.out.println(toString());
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E item = items[top];

        // null 로 초기화
        // items[top] 이 참조하던 객체가 가비지 컬렉션에 의해 정리되도록 한다
        items[top--] = null;

        if (size() > 0 && size() == items.length/4) {
            resize(items.length/2);
        }

        System.out.println(toString());

        return item;
    }

    private void resize(int size) {
        Object[] objects = new Object[size];

        for (int i = 0; i < size(); i++) {
           objects[i] = items[i];
        }

        this.items = (E[]) objects;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size(); i++) {
            stringBuilder.append(items[i]).append(" ");
        }
        return stringBuilder.toString() + " < top";
    }
}
