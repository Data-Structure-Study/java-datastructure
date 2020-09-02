package dev.idion.stack;

import java.util.EmptyStackException;

/**
 * Stack 구현체
 * @author dion
 * @version 1.0.0
 * @param <T>
 */
public class Stack<T> {

    /**
     * Top Node 스택의 맨 위
     */
    private Node<T> top;
    /**
     * Stack의 원소 수
     */
    private int count;

    /**
     * Stack이 비었는지 여부
     * @return Stack이 비었다면 true, 아니라면 false
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Stack에 있는 원소의 개수
     * @return Stack에 존재하는 모든 Node의 개수를 반환합니다.
     */
    public int size() {
        return count;
    }

    /**
     * Stack의 Top 위치에 Node 추가
     * data를 Node로 감싸고, top에 위치했던 Node를 새로운 Node의 다음 노드로 주소 저장
     * top에는 새로운 Node의 주소를 저장
     * @param data 추가할 데이터
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.nextNode = top;
        top = newNode;
        count++;
    }

    /**
     * Stack의 top 부분에 어떤 값이 있는지 확인
     * Node는 삭제하지 않음
     * @return top의 Data
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    /**
     * Stack의 top에 위치한 데이터를 꺼냄
     * Node가 삭제됨.
     * @return top에 위치했던 Data
     */
    public T pop() {
        T temp = peek();
        top = top.nextNode;
        count--;
        return temp;
    }

    /**
     * Stack의 Node 구현체(Singly Linked List와 동일)
     * @author dion
     * @param <E>
     */
    private static class Node<E> {

        /**
         * Node의 데이터, 값
         */
        private final E data;
        /**
         * 다음 Node의 참조 주소
         */
        private Node<E> nextNode;

        /**
         * Node의 생성자
         * @param data Node가 가질 data
         */
        public Node(E data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}
