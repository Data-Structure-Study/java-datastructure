package sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RadixSortTest {

  @Test
  @DisplayName("기수_정렬_테스트")
  void 기수_정렬_테스트() {
    int[] array = {13, 212, 14, 7141, 10987, 6, 15};
    int maxLength = 5;

    RadixSort radixSort = new RadixSort();
    radixSort.sort(array, maxLength);
    assertThat(array).containsExactly(6, 13, 14, 15, 212, 7141, 10987);
  }
}
