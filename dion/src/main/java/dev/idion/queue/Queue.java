package dev.idion.queue;

import java.util.NoSuchElementException;

/**
 * FIFO 자료구조인 Queue 자료구조 구현체
 * 먼저 들어온 데이터가 먼저 출력된다.
 *
 * @param <T>
 * @author dion
 * @version 1.0.0
 */
public class Queue<T> {

    /**
     * Queue의 맨 첫번째 Node
     */
    private Node<T> front;
    /**
     * Queue의 맨 마지막 Node
     */
    private Node<T> rear;
    /**
     * Queue의 원소 수
     */
    private int size;

    /**
     * Queue의 생성자
     * 초기화시에 front와 rear를 같은 Node를 참조하도록 설정
     * Sentinel Node
     */
    public Queue() {
        front = rear = new Node<>();
    }

    /**
     * Queue가 비었는지 여부
     *
     * @return 비었다면 true, 아니라면 false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Queue에 저장되어 있는 원소의 수
     *
     * @return 저장된 원소의 개수
     */
    public int size() {
        return size;
    }

    /**
     * rear에 data 추가
     *
     * @param data 추가할 데이터
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    /**
     * front의 data 꺼내기
     *
     * @return 꺼내진 데이터
     */
    public T dequeue() {
        T data = peek();
        front.next = front.next.next;
        size--;

        if (isEmpty()) {
            front = rear;
        }

        return data;
    }

    /**
     * peekFront를 쉽게 호출하기 위한 메소드
     *
     * @return 맨 앞 Node의 데이터
     */
    public T peek() {
        return this.peekFront();
    }

    /**
     * 맨 앞 Node의 data를 확인
     *
     * @return 맨 앞 Node의 데이터
     */
    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue가 비어있습니다.");
        }
        return front.next.data;
    }

    /**
     * 맨 뒤 Node의 data를 확인
     *
     * @return 맨 뒤 Node의 데이터
     */
    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue가 비어있습니다.");
        }
        return rear.data;
    }

    /**
     * Queue의 Node 구현체
     *
     * @param <E>
     * @author dion
     * @version 1.0.0
     */
    private static class Node<E> {

        /**
         * Node에 저장된 데이터
         */
        private E data;
        /**
         * 다음 Node의 참조값
         */
        private Node<E> next;

        public Node() {}

        /**
         * Node의 생성자
         *
         * @param data Node에 저장될 data
         */
        public Node(E data) {
            this.data = data;
        }
    }
}
