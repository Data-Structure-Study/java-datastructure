package dev.idion.queue;

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

        /**
         * Node의 생성자
         * @param data Node에 저장될 data
         */
        public Node(E data) {
            this.data = data;
        }
    }
}
