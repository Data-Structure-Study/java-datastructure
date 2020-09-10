package com.codesquad.datastructurestudy.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      list.add(i,i+1);
    }

    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    System.out.println("리스트의 합계는 : " + sum);

    List list1 = new ArrayList();

    for (int i = 0; i < list.size(); i++) {
      if (!(list.get(i) % 3 == 0 || list.get(i) % 2 == 0)) {
        list1.add(list.get(i));
      }
    }

    Iterator<Integer> iterator = list1.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
