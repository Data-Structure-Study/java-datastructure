package com.codesquad.datastructurestudy.list.linkedlist.yoon;

import java.util.Scanner;

public class Solution4_1 {

  private static Node dummyNode = new Node();
  private static Node head;
  private static Node tail;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    dummyNode.data = 100;
    dummyNode.next = null;
    head = dummyNode;
    tail = dummyNode;
    int num = 0;

    // 데이터 삽입
    while(true) {
      Node newNode = new Node();
      System.out.print("자연수 입력 : ");
      num = scanner.nextInt();
      if (num < 1) {
        break;
      }

      newNode.data = num;
      newNode.next = null;

      if (tail == dummyNode) {
        dummyNode.next = newNode;
        tail = newNode;
      } else {
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
      }
    }

    // 데이터 조회
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
  }

  private static class Node {
    private int data;
    private Node next;
  }
}
