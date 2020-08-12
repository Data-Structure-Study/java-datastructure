package heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UsefulHeapTest {

  @Test
  @DisplayName("쓸만한_힙의_초기화_테스트")
  void 쓸만한_힙의_초기화_테스트() {
    UsefulHeap<Character> charHeap = new ArrayUsefulHeap<>((o1, o2) -> o2 - o1);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("쓸만한_힙_저장_테스트")
  void 쓸만한_힙_저장_테스트(char firstElem, char secondElem, char thirdElem) {
    UsefulHeap<Character> charHeap = new ArrayUsefulHeap<>((o1, o2) -> o2 - o1);

    charHeap.insert(firstElem);
    charHeap.insert(secondElem);
    charHeap.insert(thirdElem);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("쓸만한_힙_저장_후_제거_테스트")
  void 쓸만한_힙_저장_후_제거_테스트(char firstElem, char secondElem, char thirdElem) {
    UsefulHeap<Character> charHeap = new ArrayUsefulHeap<>((o1, o2) -> o2 - o1);

    charHeap.insert(firstElem);
    charHeap.insert(secondElem);
    charHeap.insert(thirdElem);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
    assertThat(charHeap.delete()).isEqualTo(firstElem);
    assertThat(charHeap.delete()).isEqualTo(secondElem);
    assertThat(charHeap.delete()).isEqualTo(thirdElem);
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("쓸만한_힙_사용_테스트")
  void 쓸만한_힙_사용_테스트(char firstElem, char secondElem, char thirdElem) {
    UsefulHeap<Character> charHeap = new ArrayUsefulHeap<>((o1, o2) -> o2 - o1);

    charHeap.insert(firstElem);
    charHeap.insert(secondElem);
    charHeap.insert(thirdElem);

    assertThat(charHeap.delete()).isEqualTo('A');

    charHeap.insert(firstElem);
    charHeap.insert(secondElem);
    charHeap.insert(thirdElem);

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
