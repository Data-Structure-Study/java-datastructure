package recursion;

public class RecursiveBinarySearch {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9};
    int idx = bSearch(arr, 0, arr.length - 1, 7);
    if (idx != -1) {
      System.out.println("타겟 저장 인덱스: " + idx);
    } else {
      System.out.println("탐색 실패");
    }

    idx = bSearch(arr, 0, arr.length - 1, 4);
    if (idx != -1) {
      System.out.println("타겟 저장 인덱스: " + idx);
    } else {
      System.out.println("탐색 실패");
    }
  }

  public static int bSearch(int[] arr, int first, int last, int target) {
    if (first > last) {
      return -1;
    }
    int mid = (first + last) / 2;

    if (arr[mid] == target) {
      return mid;
    }
    if (arr[mid] > target) {
      return bSearch(arr, first, mid - 1, target);
    }
    return bSearch(arr, mid + 1, last, target);
  }
}
