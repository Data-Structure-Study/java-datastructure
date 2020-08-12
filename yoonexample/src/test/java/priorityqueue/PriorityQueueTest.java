package priorityqueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.EmptyQueueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriorityQueueTest {

  @Test
  @DisplayName("우선순위_큐_초기화_테스트")
  void 우선순위_큐_초기화_테스트() {
    PriorityQueue<Character> priorityQueue = new HeapPriorityQueue<>((o1, o2) -> o2 - o1);

    assertThat(priorityQueue).isNotNull();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("우선순위_큐_저장_테스트")
  void 우선순위_큐_저장_테스트(char firstElem, char secondElem, char thirdElem) {
    PriorityQueue<Character> charHeap = new HeapPriorityQueue<>((o1, o2) -> o2 - o1);

    charHeap.enqueue(firstElem);
    charHeap.enqueue(secondElem);
    charHeap.enqueue(thirdElem);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("우선순위_큐_저장_후_제거_테스트")
  void 우선순위_큐_저장_후_제거_테스트(char firstElem, char secondElem, char thirdElem) {
    PriorityQueue<Character> charHeap = new HeapPriorityQueue<>((o1, o2) -> o2 - o1);

    charHeap.enqueue(firstElem);
    charHeap.enqueue(secondElem);
    charHeap.enqueue(thirdElem);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
    assertThat(charHeap.dequeue()).isEqualTo(firstElem);
    assertThat(charHeap.dequeue()).isEqualTo(secondElem);
    assertThat(charHeap.dequeue()).isEqualTo(thirdElem);
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"'A','B','C'"})
  @DisplayName("우선순위_큐_사용_테스트")
  void 우선순위_큐_사용_테스트(char firstElem, char secondElem, char thirdElem) {
    PriorityQueue<Character> charHeap = new HeapPriorityQueue<>((o1, o2) -> o2 - o1);

    charHeap.enqueue(firstElem);
    charHeap.enqueue(secondElem);
    charHeap.enqueue(thirdElem);

    assertThat(charHeap.dequeue()).isEqualTo('A');

    charHeap.enqueue(firstElem);
    charHeap.enqueue(secondElem);
    charHeap.enqueue(thirdElem);

    assertThat(charHeap).isNotNull();
    assertThat(charHeap.isEmpty()).isFalse();
    assertThat(charHeap.dequeue()).isEqualTo(firstElem);
    assertThat(charHeap.dequeue()).isEqualTo(secondElem);
    assertThat(charHeap.dequeue()).isEqualTo(secondElem);
    assertThat(charHeap.dequeue()).isEqualTo(thirdElem);
    assertThat(charHeap.dequeue()).isEqualTo(thirdElem);
    assertThat(charHeap.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("우선순위_큐_제거시_에러_테스트")
  void 우선순위_큐_제거시_에러_테스트() {
    PriorityQueue<Character> charHeap = new HeapPriorityQueue<>((o1, o2) -> o2 - o1);

    assertThat(charHeap).isNotNull();
    assertThatThrownBy(charHeap::dequeue).isInstanceOf(EmptyQueueException.class);
    assertThat(charHeap.isEmpty()).isTrue();
  }
}
