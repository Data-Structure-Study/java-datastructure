package queue;

import java.util.NoSuchElementException;

public class QueueSunny<T> {

    private Node first; // 가장 예전에 추가한 노드
    private Node last;  // 가장 최근에 추가한 노드
    private int sectionAmount;  // 큐에 저장된 항목의 갯수

    private class Node {    // 노드를 정의하는 클래스
        T object;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return sectionAmount;
    }

    public void enqueue(T object) {
        Node oldLast = last;
        last = new Node();
        last.object = object;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        sectionAmount++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T object = first.object;
        first = first.next;
        sectionAmount--;
        if (isEmpty()) {
            last = null;
        }

        return object;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.object;
    }
}
