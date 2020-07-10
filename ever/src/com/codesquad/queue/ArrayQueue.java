package com.codesquad.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> {

    // 큐의 배열
    private E[] items;

    private int front;

    private int rear;

    private int size;

    public ArrayQueue() {

        /*
        초기에 크기가 2인 배열을 생성한다

        Front가 0번째 인덱스가 아닌
        1번째 인덱스를 가리켜야 하기 때문
        */
        items = (E[]) new Object[2];

        front = 0;
        rear = 0;
        size = 0;
    }

    // 큐에 있는 항목의 수를 리턴
    public int size() {
        return size;
    }

    // 큐가 비어있으면 true를 리턴
    public boolean isEmpty() {
        return size == 0;
    }

    // 큐 삽입 연산
    public void add(E item) {
        // 비어있는 원소가 1개뿐인 경우(즉, 큐가 full 인 경우)
        // (rear+1)%length는 rear 다음 원소의 인덱스를 의미
        if ((rear+1)%items.length == front)
            resize(2*items.length);

        rear = (rear+1)%items.length;

        // 새 항목을 add
        items[rear] = item;

        size++;

        System.out.println(toString());
    }

    // 큐 삭제 연산
    public E remove() {
        // underflow 경우에 프로그램 정지
        if (isEmpty()) throw new NoSuchElementException();
        front = (front+1)%items.length;
        E item = items[front];

        // null로 만들어 가비지 컬렉션이 되도록
        items[front] = null;

        size--;

        // 큐의 항목 수가 배열 크기의 4분의 1이 된다면
        if (size > 0 && size == items.length/4)
            resize(items.length/2);

        System.out.println(toString());

        return item;
    }

    private void resize(int newSize) {
        System.out.println();
        System.out.println("Run Resize");
        System.out.println();

        Object[] objects = new Object[newSize];

        for (int i = 1, j = front + 1; i < size+1; i++, j++) {
            objects[i] = items[j%items.length];
        }

        front = 0;
        rear = size;
        this.items = (E[]) objects;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(items).forEach(item -> stringBuilder.append(item).append(" "));

        return stringBuilder.toString();
    }
}
