package search;

public class InterpolSearch {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9};

    int idx = iSearch(arr, 7);
    printSearchInfo(idx);

    idx = iSearch(arr, 4);
    printSearchInfo(idx);

    idx = iSearch(arr, 2);
    printSearchInfo(idx);
  }

  public static int iSearch(int[] arr, int target) {
    int first = 0; // 탐색 대상의 시작 인덱스 값
    int last = arr.length - 1; // 탐색 대상의 마지막 인덱스 값
    int mid;

    while (!(arr[first] > target || arr[last] < target)) {
      mid = (int) ((double) (target - arr[first]) / (arr[last] - arr[first]) * (last - first))
          + first;

      if (arr[mid] == target) {
        return mid;
      } else if (target < arr[mid]) { // 탐색 대상이 아니라면 반으로 줄입니다.
        last = mid - 1; // 왜 mid에서 1을 뺄까요?
      } else {
        first = mid + 1; // 왜 mid에서 1을 더할까요?
      }
    }
    return -1;
  }

  public static void printSearchInfo(int idx) {
    String info = "탐색 실패";
    if (idx != -1) {
      info = "타겟 저장 인덱스: " + idx;
    }
    System.out.println(info);
  }
}
