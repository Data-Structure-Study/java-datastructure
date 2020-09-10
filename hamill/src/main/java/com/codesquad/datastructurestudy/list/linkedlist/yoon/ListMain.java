package com.codesquad.datastructurestudy.list.linkedlist.yoon;

public class ListMain {

  public static void main(String[] args) {

    DummyLinkedList list = new DummyLinkedList(true);
    list.add(11);
    list.add(22);
    list.add(11);
    list.add(22);
    list.add(33);

    System.out.println("현재 데이터의 수: " + list.size());

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    list.remove(1);
    list.remove(1);

    System.out.println("현재 데이터의 수: " + list.size());

    System.out.println(list.get(0));;
    System.out.println(list.get(1));;
    System.out.println(list.get(2));;
  }
}
