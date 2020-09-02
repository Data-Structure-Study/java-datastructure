package com.codesquad.datastructurestudy.list.arraylist;

public interface List<T> {

  void add(T element);
  void add(int index, T element);

  int count();

  T get(int index);

  T remove(int index);

  int size();

//  int indexOf(T o);
//  int lastIndexOf(T o);

//  ListIterator listIterator();
//  ListIterator listIterator(int index);

//  T set(int index, T element);

//  void sort(Comparator c);

//  List subList(int fromIndex, int toIndex);
}
