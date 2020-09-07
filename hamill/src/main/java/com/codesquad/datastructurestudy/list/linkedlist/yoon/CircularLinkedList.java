package com.codesquad.datastructurestudy.list.linkedlist.yoon;

public class CircularLinkedList {

  private Node tail;
  private int count;
  private Node before;
  private Node cur;

  public void add(int data) {
    Node newNode = new Node(data);

    if (tail == null) {
      tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = tail.next;
      tail.next = newNode;
      tail = newNode;
    }
    count++;
  }

  public void addName(int data, String name) {
    Node newNode = new Node(data);
    newNode.name = name;

    if (tail == null) {
      tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = tail.next;
      tail.next = newNode;
      tail = newNode;
    }
    count++;
  }

  public void addFront(int data) {
    Node newNode = new Node(data);

    if (tail == null) {
      tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = tail.next;
      tail.next = newNode;
    }
    count++;
  }

  public void addNameFront(int data, String name) {
    Node newNode = new Node(data);
    newNode.name = name;

    if (tail == null) {
      tail = newNode;
      newNode.next = newNode;
    } else {
      newNode.next = tail.next;
      tail.next = newNode;
    }
    count++;
  }

  public boolean first() {
    if (tail == null) {
      return false;
    } else {
      before = tail;
      cur = tail.next;
      return true;
    }
  }

  public boolean next(int data) {
    if (tail == null) {
      return false;
    } else {
      before = cur;
      cur = cur.next;
      return true;
    }
  }

  public int remove() {
    Node deleteNode = cur;
    int data = deleteNode.data;

    if (deleteNode == tail) {
      if (tail == tail.next) {
        tail = null;
      } else {
        tail = before;
      }
    }

    before.next = cur.next;
    cur = before;
    count--;
    return data;
  }

  public int size() {
    return this.count;
  }

  public String identifyWatcher(String name, int afterNum) {
    Node searchNode = new Node();
    searchNode.next = tail.next;
    int count = 0;
    String watcher = null;

    while (true) {
      if (searchNode.name == name) {
        break;
      } else {
        searchNode = searchNode.next;
        count++;
      }
    }

    for (int i = 0; i < afterNum + count; i++) {
      if (i != afterNum + count - 1) {
        searchNode = searchNode.next;
        continue;
      } else {
        watcher = searchNode.name;
      }
    }
    return watcher;
  }

  public static void main(String[] args) {
    CircularLinkedList members = new CircularLinkedList();

    members.addName(1, "김");
    members.addName(2, "나");
    members.addName(3, "박");
    members.addName(4, "이");

    System.out.println("서치 시작");

    System.out.println(members.identifyWatcher("김", 7));

  }

  private class Node {

    private int data;
    private String name;
    private Node next;

    public Node() {
      this.data = 0;
      this.next = null;
    }

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
