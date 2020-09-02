package com.codesquad.datastructurestudy.basic;

public class BinarySearch {

  private static int binarySearch(int[] numbers, int number, int first, int last) {
    while (first <= last) {
      int mid = (first + last) / 2;

      if (numbers[mid] == number) {
        return mid;
      } else if (numbers[mid] < number) {
        first = mid + 1;
      } else {
        last = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5,6,7,8,9};
    int number = 2;
    int index = binarySearch(numbers, number, 0, numbers.length - 1);

    if (index == -1) {
      System.out.println("못찾았다");
    } else {
      System.out.println(index + "번째 인덱스에서 찾았다");
    }
  }
}
