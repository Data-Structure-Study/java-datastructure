package list;

import java.util.Scanner;

public class LinkedRead {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Node<Integer> head = null;
    Node<Integer> tail = null;
    Node<Integer> cur = null;

    Node<Integer> newNode;
    int readData;

    // 데이터를 입력 받는 과정
    while (true) {
      System.out.print("자연수 입력(0은 탈출) : ");
      readData = Integer.parseInt(sc.nextLine()); // 예외처리가 필요하지만 하지 않았습니다.

      if (readData == 0) {
        break;
      }

      newNode = new Node<>(readData);

      if (head == null) {
        head = newNode;
      } else {
        tail.next = newNode;
      }
      tail = newNode;
    }

    // 입력 받은 데이터의 출력과정
    System.out.println("\n입력 받은 데이터 전체 출력!");
    if (head == null) {
      System.out.println("저장된 자연수가 존재하지 않습니다.");
    } else {
      cur = head;
      System.out.print(cur.data + " ");

      while (cur.next != null) {
        cur = cur.next;
        System.out.print(cur.data + " ");
      }
    }

    // 저장된 데이터를 삭제하는 과정
    if (head != null) {
      Node<Integer> delNode = head;
      Node<Integer> delNextNode = head.next;

      System.out.println(head.data + "을(를) 삭제합니다.");
      head = null; // 참조하는 것이 없어져서 gc의 대상이 됩니다.

      while (delNextNode != null) {
        delNode = delNextNode;
        delNextNode = delNode.next;

        System.out.println(delNode.data + "을(를) 삭제합니다.");
        delNode = null;
      }
      tail = null;
      cur = null;
    }
  }

  private static class Node<E> {

    private final E data;
    private Node<E> next;

    public Node(E data) {
      this.data = data;
    }
  }
}
