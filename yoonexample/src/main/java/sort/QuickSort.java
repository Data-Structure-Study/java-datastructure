package sort;

public class QuickSort implements Sort {

  @Override
  public void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(int[] array, int left, int right) {
    if (left < right) { // 교차되기 전까지
      int pivot = partition(array, left, right);
      quickSort(array, left, pivot - 1);
      quickSort(array, pivot + 1, right);
    }
  }

  private int partition(int[] array, int left, int right) {
    int pivot = array[left];
    int k = right;

    for (int i = right; i > left; i--) {
      if (array[i] > pivot) {
        swap(array, i, k);
        k--;
      }
    }

    swap(array, left, k);
    return k;
  }

  private void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
