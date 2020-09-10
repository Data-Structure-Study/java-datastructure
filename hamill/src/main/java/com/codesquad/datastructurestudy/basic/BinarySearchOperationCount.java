package com.codesquad.datastructurestudy.basic;

import java.util.Arrays;

public class BinarySearchOperationCount {

  private static int binarySearch(int[] numbers, int number, int first, int last) {
    int mid;
    int opCount = 0;

    while (first <= last) {
      mid = (first + last) / 2;

      if (numbers[mid] == number) {
        return mid;
      } else if (numbers[mid] < number) {
        first = mid + 1;
      } else {
        last = mid - 1;
      }
      opCount++;
    }
    return opCount;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[500];
    int[] arr2 = new int[5000];
    int[] arr3 = new int[50000];
    int number = 5000;

    Arrays.fill(arr1, 0);
    Arrays.fill(arr2, 0);
    Arrays.fill(arr3, 0);

    int opCount1 = binarySearch(arr1, number, 0, arr1.length - 1);
    int opCount2 = binarySearch(arr2, number, 0, arr2.length - 1);
    int opCount3 = binarySearch(arr3, number, 0, arr3.length - 1);

    System.out.println("비교연산횟수 : " + opCount1);
    System.out.println("비교연산횟수 : " + opCount2);
    System.out.println("비교연산횟수 : " + opCount3);
  }
}
