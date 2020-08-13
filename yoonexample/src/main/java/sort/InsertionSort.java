package sort;

public class InsertionSort implements Sort {

  @Override
  public void sort(int[] array) {
    int length = array.length;
    int insertData;

    for (int i = 1; i < length; i++) {
      insertData = array[i];
      int j;

      for (j = i - 1; j >= 0; j--) { // 정렬된 배열의 뒷부분 부터 비교해서 삽입위치 탐색
        if (array[j] > insertData) { // 삽입할 데이터가 작으면
          array[j + 1] = array[j]; // 위치 변경
        } else {
          break; // 해당 위치에 삽입되어야 하므로 탈출
        }
      }

      array[j + 1] = insertData;
    }
  }
}
