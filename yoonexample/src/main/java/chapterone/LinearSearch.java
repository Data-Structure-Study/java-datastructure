package chapterone;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 9};

        int idx = lSearch(arr, 4);
        printSearchInfo(idx);

        idx = lSearch(arr, 7);
        printSearchInfo(idx);
    }

    public static int lSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
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
