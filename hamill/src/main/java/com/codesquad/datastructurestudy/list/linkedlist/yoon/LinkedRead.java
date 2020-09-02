package com.codesquad.datastructurestudy.list.linkedlist.yoon;

import java.util.Scanner;

public class LinkedRead {

  private static Node head;
  private static Node tail;

  public static void main(String[] args) {
    Node newNode = new Node();
    Scanner scanner = new Scanner(System.in);
//    int readData = 0;

    // 데이터 입력
    while(true) {
      System.out.println("자연수 입력: ");
      int num = scanner.nextInt();
      if (num < 1) {
        break;
      }

      newNode.data = num;
      newNode.next = null;

      if (head == null) {
        head = newNode;
      } else {
        tail.next = newNode;
      }

      tail = newNode;
    }
    System.out.println();

    // 입력 받은 데이터 출력
    System.out.println("입력 받은 데이터의 전체 출력!");
    if (head == null) {
      System.out.println("저장된 자연수가 존재하지 않습니다!");
    } else {
      Node cur = head;
      System.out.println(cur.data);

      while (cur.next != null) {
        cur = cur.next;
        System.out.println(cur.data);
      }
    }

    // 메모리 해제
    if (head == null) {
      return;
    } else {
      Node delNode = head;
      Node delNextNode = head.next;

      System.out.println(head.data + "(을)를 삭제합니다");

      while (delNextNode != null) {
        delNode = delNextNode;
        delNextNode =delNextNode.next;

        System.out.println(delNode.data + "(을)를 삭제합니다");
      }
    }
  }


  private static class Node {
    private int data;
    private Node next;

    public Node() {
      this.next = null;
    }
  }
}
