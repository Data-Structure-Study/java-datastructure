package sort;

import queue.LinkedListQueue;
import queue.Queue;

public class RadixSort {

  private static final int BUCKET_NUM = 10;

  public void sort(int[] array, int maxLength) {
    int divFac = 1;
    Queue<Integer>[] buckets = new Queue[BUCKET_NUM];

    // 버킷 배열 초기화
    for (int i = 0; i < BUCKET_NUM; i++) {
      buckets[i] = new LinkedListQueue<>();
    }

    // 가장 긴 데이터의 길이만큼 반복
    for (int i = 0; i < maxLength; i++) {
      // 정렬 대상 수의 개수만큼 반복
      for (int num : array) {
        // N번째 자리의 숫자 추출
        int radix = (num / divFac) % 10;

        // 추출한 숫자에 위치하도록 데이터 저장
        buckets[radix].enqueue(num);
      }

      // 버킷 수 만큼 반복
      int arrayIndex = 0;
      for (int j = 0; j < BUCKET_NUM; j++) {
        // 버킷에 저장되어 있는 것을 순서대로 꺼내서 다시 array에 저장
        while (!buckets[j].isEmpty()) {
          array[arrayIndex++] = buckets[j].dequeue();
        }
      }

      // N번째 자리 숫자를 추출할 수 있도록 변경
      divFac *= 10;
    }
  }
}
