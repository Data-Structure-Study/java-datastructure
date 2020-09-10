package com.codesquad.datastructurestudy.basic;

public class LinearSearch {

  private static int linearSearch(int[] numbers, int number) {
    int i;
    for (i = 0; i < numbers.length; i++) {
      if (numbers[i] == number) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int number = 2;
    int index = linearSearch(arr, number);

    if (index == -1) {
      System.out.println("못찾았다");
    } else {
      System.out.println((index+1) + "번째 에서 찾았다");
    }
  }
}
