package sort;

public class MergeSort implements Sort {

  @Override
  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int left, int right) {
    if (left < right) { // 더 나눌 수 있다면
      int mid = left + ((right - left) / 2); // https://endorphin0710.tistory.com/112 참조

      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      mergeTwoArea(array, left, mid, right);
    }
  }

  private void mergeTwoArea(int[] array, int left, int mid, int right) {
    int[] temp = new int[right + 1];
    int fIndex = left;
    int rIndex = mid + 1;
    int sIndex = left;

    while (fIndex <= mid && rIndex <= right) {
      if (array[fIndex] <= array[rIndex]) {
        temp[sIndex] = array[fIndex++];
      } else {
        temp[sIndex] = array[rIndex++];
      }

      sIndex++;
    }

    if (fIndex > mid) {
      for (int i = rIndex; i <= right; i++, sIndex++) {
        temp[sIndex] = array[i];
      }
    } else {
      for (int i = fIndex; i <= mid; i++, sIndex++) {
        temp[sIndex] = array[i];
      }
    }

    for (int i = left; i <= right; i++) {
      array[i] = temp[i];
    }
  }
}
