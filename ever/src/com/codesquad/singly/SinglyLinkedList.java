package com.codesquad.singly;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    public SinglyNode<E> head;

    public int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int search(E target) {
        SinglyNode<E> tempHead = this.head;

        for (int i = 0; i < size; i++) {
            if (target == tempHead.item) {
                return i;
            }
            tempHead = tempHead.nextSinglyNode;
        }

        return -1;
    }

    public void insertFront(E newItem) {
        this.head = new SinglyNode<>(this.head, newItem);
        size++;
    }

    // targetNode 다음에 새 노드 삽입
    public void insert(E newItem, SinglyNode<E> targetSinglyNode) {
        SinglyNode<E> nextSinglyNode = targetSinglyNode.nextSinglyNode;
        SinglyNode<E> singlyNode = new SinglyNode<>(nextSinglyNode, newItem);

        targetSinglyNode.setNextSinglyNode(singlyNode);

        size++;
    }

    public void deleteFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        this.head = this.head.nextSinglyNode;

        size--;
    }

    // targetNode가 가리키는 노드의 다음 노드를 삭제
    public void delete(SinglyNode<E> targetSinglyNode) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SinglyNode<E> deleteSinglyNode = targetSinglyNode.nextSinglyNode;
        targetSinglyNode.setNextSinglyNode(deleteSinglyNode.nextSinglyNode);
        deleteSinglyNode.setNextSinglyNode(null);

        size--;
    }

    public void findAll() {
        StringBuilder stringBuilder = new StringBuilder();

        SinglyNode<E> singlyNode = this.head;

        for (int i = 0; i < size; i++) {
            stringBuilder.append(singlyNode.item).append(" ");
            singlyNode = singlyNode.nextSinglyNode;
        }

        System.out.println(stringBuilder.toString() + " : 길이 = " + size);
    }

    private boolean isEmpty() {
        return this.size == 0;
    }
}

