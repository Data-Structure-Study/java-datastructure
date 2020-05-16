package com.codesquad.datastructurestudy.linkedlist;

public class LinkedList {
    // 첫 번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        // 노드의 내용을 쉽게 출력해서 확인 해볼 수 있는 기능
        public String toString() {
            return String.valueOf(this.data);
        }
    }
    

}
