package com.codesquad.datastructurestudy.list.arraylist;

public class ArrayList implements List<Integer> {

  private int[] numbers;
  private int numOfData;

  public ArrayList() {
    this.numbers = new int[100];
    this.numOfData = 0;
  }

  public ArrayList(int[] numbers, int numOfData) {
    this.numbers = numbers;
    this.numOfData = numOfData;
  }

  public void add(int index, Integer element) {
    if (numOfData > this.numbers.length) {
      System.out.println("배열이 가득 찼습니다");
//      throw new ArrayIndexOutOfBoundsException();
    }
    this.numbers[index] = element;
    numOfData++;
  }

  public void add(Integer element) {
    if (numOfData > this.numbers.length) {
      System.out.println("배열이 가득 찼습니다");
    }
    this.numbers[numOfData] = element;
    numOfData++;
  }

  public int count() {
    return this.numOfData;
  }

  public Integer get(int index) {
    return this.numbers[index];
  }

  public Integer remove(int index) {
    Integer data = this.numbers[index];

    for (int i = index; i < this.numOfData - 1; i++) {
      this.numbers[i] = this.numbers[i+1];
    }

    this.numOfData--;
    return data;
  }

  public int size() {
    return this.numbers.length;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList();

    // 데이터 삽입
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // 저장된 데이터 출력
    System.out.println("현재 데이터의 수: " + list.count());

    for (int i = 0; i < list.count(); i++) {
      System.out.println(list.get(i));
    }

    list.remove(2);
    list.remove(3);

    System.out.println("삭제 후 데이터의 수: " + list.count());

    for (int i = 0; i < list.count(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println("삭제 후 배열 크기: " + list.size());
  }
}
