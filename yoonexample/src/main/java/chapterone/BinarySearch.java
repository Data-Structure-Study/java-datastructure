package chapterone;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        int idx = bSearch(arr, 7);
        printSearchInfo(idx);

        idx = bSearch(arr, 4);
        printSearchInfo(idx);
    }

    public static int bSearch(int[] arr, int target) {
        int first = 0;             // 탐색 대상의 시작 인덱스 값
        int last = arr.length - 1; // 탐색 대상의 마지막 인덱스 값
        int mid;

        while (first <= last) {
            mid = (first + last) / 2; // 탐색 대상의 중앙을 찾는다.

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
