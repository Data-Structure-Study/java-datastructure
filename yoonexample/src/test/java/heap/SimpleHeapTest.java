package heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleHeapTest {

  @Test
  @DisplayName("힙의_초기화_테스트")
  void 힙의_초기화_테스트() {
    SimpleHeap<Character> charHeap = new ArraySimpleHeap<>();

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("힙_저장_테스트")
  void 힙_저장_테스트(char firstElem, char secondElem, char thirdElem) {
    SimpleHeap<Character> charHeap = new ArraySimpleHeap<>();

    charHeap.insert(firstElem, 1);
    charHeap.insert(secondElem, 2);
    charHeap.insert(thirdElem, 3);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("힙_저장_후_제거_테스트")
  void 힙_저장_후_제거_테스트(char firstElem, char secondElem, char thirdElem) {
    SimpleHeap<Character> charHeap = new ArraySimpleHeap<>();

    charHeap.insert(firstElem, 1);
    charHeap.insert(secondElem, 2);
    charHeap.insert(thirdElem, 3);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
    assertThat(charHeap.delete()).isEqualTo(firstElem);
    assertThat(charHeap.delete()).isEqualTo(secondElem);
    assertThat(charHeap.delete()).isEqualTo(thirdElem);
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("힙_사용_테스트")
  void 힙_사용_테스트(char firstElem, char secondElem, char thirdElem) {
    SimpleHeap<Character> charHeap = new ArraySimpleHeap<>();

    charHeap.insert(firstElem, 1);
    charHeap.insert(secondElem, 2);
    charHeap.insert(thirdElem, 3);

    assertThat(charHeap.delete()).isEqualTo('A');

    charHeap.insert(firstElem, 1);
    charHeap.insert(secondElem, 2);
    charHeap.insert(thirdElem, 3);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
    assertThat(charHeap.delete()).isEqualTo(firstElem);
    assertThat(charHeap.delete()).isEqualTo(secondElem);
    assertThat(charHeap.delete()).isEqualTo(secondElem);
    assertThat(charHeap.delete()).isEqualTo(thirdElem);
    assertThat(charHeap.delete()).isEqualTo(thirdElem);
    assertThat(charHeap.isEmpty()).isTrue();
  }
}
