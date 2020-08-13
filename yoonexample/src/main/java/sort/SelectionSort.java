package sort;

public class SelectionSort implements Sort {

  @Override
  public void sort(int[] array) {
    int length = array.length;
    int maxIndex;
    int temp;
    for (int i = 0; i < length - 1; i++) {
      maxIndex = i;
      for (int j = i + 1; j < length; j++) { // 최솟값 탐색
        if (array[j] < array[maxIndex]) {
          maxIndex = j;
        }
      }

      // swap
      temp = array[i];
      array[i] = array[maxIndex];
      array[maxIndex] = temp;
    }
  }
}
