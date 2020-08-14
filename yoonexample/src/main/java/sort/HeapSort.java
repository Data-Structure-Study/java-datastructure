package sort;

import heap.ArrayUsefulHeap;
import heap.UsefulHeap;
import java.util.Comparator;

public class HeapSort implements Sort {

  @Override
  public void sort(int[] array) {
    this.sort(array, ((o1, o2) -> o2 - o1));
  }

  private void sort(int[] array, Comparator<Integer> comp) {
    UsefulHeap<Integer> heap = new ArrayUsefulHeap<>(comp);

    // 정렬 대상을 가지고 힙을 구성한다.
    for (int i : array) {
      heap.insert(i);
    }

    // 힙에서 하나씩 꺼내서 정렬된 구조로 반환한다.
    for (int i = 0; i < array.length; i++) {
      array[i] = heap.delete();
    }
  }
}
