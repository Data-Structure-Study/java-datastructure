package com.codesquad.datastructurestudy.recursive;

import java.util.Arrays;

public class RecursiveBinarySearch {

  private static int recursiveBSearch(int[] numbers, int first, int last, int target) {

    if (first > last) {
      return -1;
    }

    int mid = (first + last) / 2;
    if (numbers[mid] == target) {
      return mid;
    } else if (numbers[mid] < target) {
      return recursiveBSearch(numbers, mid + 1, last, target);
    } else {
      return recursiveBSearch(numbers, first, mid - 1, target);
    }
  }

  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5,6,7,8,9};
    int[] numbers1 = new int[5000];
    Arrays.fill(numbers1, 0);

    int index1 = recursiveBSearch(numbers1, 0, numbers1.length-1, 50);
    int index = recursiveBSearch(numbers, 0, numbers.length-1, 9);
    System.out.println(index);
    System.out.println(index1);
  }
}
