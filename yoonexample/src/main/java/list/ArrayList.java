package list;

import java.util.Comparator;

public class ArrayList<E> implements List<E> {

  private static final int INITIAL_CAPACITY = 100;

  private int size;
  private Object[] arr;
  private Comparator<E> comp;

  public ArrayList() {
    this.arr = new Object[INITIAL_CAPACITY];
  }

  @Override
  public void insert(E data) {
    if (this.size >= INITIAL_CAPACITY) { // 더 이상 저장할 공간이 없다면
      System.out.println("저장이 불가능합니다.");
      return;
    }

    arr[this.size] = data; // 데이터 저장
    this.size++; // 데이터 수의 증가
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean contains(Object o) {
    if (o == null) {
      for (int i = 0; i < this.size; i++) {
        if (this.get(i) == null) {
          return true;
        }
      }
    } else {
      for (int i = 0; i < this.size; i++) {
        if (o.equals(this.get(i))) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public E get(int index) {
    return (E) arr[index];
  }

  @Override
  public E remove(int index) {
    E data = this.get(index);

    for (int i = index; i < this.size; i++) {
      arr[i] = arr[i + 1];
    }

    this.size--;
    return data;
  }

  @Override
  public void setSortRule(Comparator<E> comp) {
    this.comp = comp;
  }
}
