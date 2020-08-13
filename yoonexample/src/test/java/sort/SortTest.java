package sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {

  long beforeTime;
  long afterTime;

  @BeforeEach
  void setUp() {
    beforeTime = System.currentTimeMillis();
  }

  @AfterEach
  void tearDown() {
    afterTime = System.currentTimeMillis();
    System.out.println("===========>실행시간(ms): " + (afterTime - beforeTime));
  }

  @Test
  @DisplayName("버블_정렬_테스트")
  void 버블_정렬_테스트() {
    Sort sort = new BubbleSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("선택_정렬_테스트")
  void 선택_정렬_테스트() {
    Sort sort = new SelectionSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("삽입_정렬_테스트")
  void 삽입_정렬_테스트() {
    Sort sort = new InsertionSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("힙_정렬_테스트")
  void 힙_정렬_테스트() {
    Sort sort = new HeapSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("병합_정렬_테스트")
  void 병합_정렬_테스트() {
    Sort sort = new MergeSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("퀵_정렬_테스트")
  void 퀵_정렬_테스트() {
    Sort sort = new QuickSort();

    // Repeated Test 사용시 각각 실행시간이 찍혀서 어쩔 수 없이 반복 (1억번)
    for (int i = 0; i < 100_000_000; i++) {
      int[] actual = {1, 4, 5, 2, 3, 7, 6};
      int[] expected = {1, 2, 3, 4, 5, 6, 7};
      sort.sort(actual);

      assertThat(actual).isEqualTo(expected);
    }
  }
}
