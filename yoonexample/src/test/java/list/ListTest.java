package list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ListTest {

  @Test
  void ArrayList의_생성_및_초기화() {
    List<Integer> list = new ArrayList<>();

    assertThat(list).isNotNull();
  }

  @ParameterizedTest
  @CsvSource({"11,11,22,22,33"})
  void 데이터_5개_저장(int firstElem, int secondElem, int thirdElem, int fourthElem, int fifthElem) {
    List<Integer> list = new ArrayList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);
    list.insert(fourthElem);
    list.insert(fifthElem);

    int expectedSize = 5;
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.get(0)).isEqualTo(firstElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(thirdElem);
    assertThat(list.get(3)).isEqualTo(fourthElem);
    assertThat(list.get(4)).isEqualTo(fifthElem);
  }

  @ParameterizedTest
  @CsvSource({"11,11,22,22,33"})
  void 데이터_5개_저장_후_22인_데이터_모두_삭제(int firstElem, int secondElem, int thirdElem, int fourthElem,
      int fifthElem) {
    List<Integer> list = new ArrayList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);
    list.insert(fourthElem);
    list.insert(fifthElem);

    // Iterable을 구현하면 enhanced for loop를 사용할 수 있습니다.
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 22) {
        list.remove(i);
        i--; // 삭제되면 index가 조정되므로 해당 index부터 다시 확인해야 합니다.
      }
    }

    int expectedSize = 3;
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.get(0)).isEqualTo(firstElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(fifthElem);
  }

  @Test
  void CircularLinkedList의_생성_및_초기화() {
    List<Integer> list = new CircularLinkedList<>();

    assertThat(list).isNotNull();
  }

  @ParameterizedTest
  @CsvSource({"11,11,22,22,33"})
  void CircularLinkedList에_데이터_5개_저장(int firstElem, int secondElem, int thirdElem, int fourthElem,
      int fifthElem) {
    List<Integer> list = new CircularLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);
    list.insert(fourthElem);
    list.insert(fifthElem);

    int expectedSize = 5;
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.get(0)).isEqualTo(firstElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(thirdElem);
    assertThat(list.get(3)).isEqualTo(fourthElem);
    assertThat(list.get(4)).isEqualTo(fifthElem);
    assertThat(list.get(5)).isEqualTo(firstElem);
  }

  @ParameterizedTest
  @CsvSource({"11,11,22,22,33"})
  void CircularLinkedList에_데이터_5개_저장_후_22인_데이터_모두_삭제(int firstElem, int secondElem, int thirdElem,
      int fourthElem, int fifthElem) {
    List<Integer> list = new CircularLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);
    list.insert(fourthElem);
    list.insert(fifthElem);

    // Iterable을 구현하면 enhanced for loop를 사용할 수 있습니다.
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 22) {
        list.remove(i);
        i--; // 삭제되면 index가 조정되므로 해당 index부터 다시 확인해야 합니다.
      }
    }

    int expectedSize = 3;
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.get(0)).isEqualTo(firstElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(fifthElem);
    assertThat(list.get(3)).isEqualTo(firstElem);
  }

  @Test
  @DisplayName("CircularLinkedList 에러처리 확인")
  void CircularLinkedList_에러처리_확인() {
    List<Integer> list = new CircularLinkedList<>();

    assertThat(list.get(3)).isNull();
    assertThat(list.remove(4)).isNull();
    assertThat(list.contains(null)).isFalse();
    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("CircularLinkedList 에러처리 확인2")
  void CircularLinkedList_에러처리_확인2() {
    List<Integer> list = new CircularLinkedList<>();

    list.insert(1);

    assertThat(list.get(3)).isEqualTo(1);
    assertThat(list.contains(null)).isFalse();
    assertThat(list.remove(4)).isEqualTo(1);
    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("DoublyLinkedList의 생성 및 초기화 테스트")
  void DoublyLinkedList의_생성_및_초기화_테스트() {
    List<Integer> list = new DoublyLinkedList<>();

    assertThat(list).isNotNull();
  }

  @ParameterizedTest
  @CsvSource({"11,22,33"})
  @DisplayName("DoublyLinkedList 데이터 3개 저장 테스트")
  void DoublyLinkedList_데이터_3개_저장_테스트(int firstElem, int secondElem, int thirdElem) {
    List<Integer> list = new DoublyLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);

    int expectedSize = 3;
    int notContainsElem = 44;
    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.contains(firstElem)).isTrue();
    assertThat(list.contains(secondElem)).isTrue();
    assertThat(list.contains(thirdElem)).isTrue();
    assertThat(list.contains(notContainsElem)).isFalse();
    assertThat(list.get(0)).isEqualTo(thirdElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(firstElem);
  }

  @ParameterizedTest
  @CsvSource({"11,22,33"})
  @DisplayName("DoublyLinkedList 데이터 3개 저장 후 삭제 테스트")
  void DoublyLinkedList_데이터_3개_저장_후_삭제_테스트(int firstElem, int secondElem, int thirdElem) {
    List<Integer> list = new DoublyLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);

    list.remove(2);
    list.remove(1);

    int expectedSize = 1;
    int notContainsElem = 44;
    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.contains(firstElem)).isFalse();
    assertThat(list.contains(secondElem)).isFalse();
    assertThat(list.contains(thirdElem)).isTrue();
    assertThat(list.contains(notContainsElem)).isFalse();
    assertThat(list.get(0)).isEqualTo(thirdElem);
  }

  @Test
  @DisplayName("DoublyLinkedList 예외 처리 테스트")
  void DoublyLinkedList_예외_처리_테스트() {
    List<Integer> list = new DoublyLinkedList<>();

    assertThat(list.get(3)).isNull();
    assertThat(list.remove(4)).isNull();
    assertThat(list.contains(null)).isFalse();
    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("DoublyLinkedList 예외 처리 테스트2")
  void DoublyLinkedList_예외_처리_테스트2() {
    List<Integer> list = new DoublyLinkedList<>();

    list.insert(1);

    assertThat(list.get(3)).isNull();
    assertThat(list.remove(4)).isNull();
    assertThat(list.contains(null)).isFalse();
    assertThat(list.size()).isEqualTo(1);
    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("DummyDoublyLinkedList의 생성 및 초기화 테스트")
  void DummyDoublyLinkedList의_생성_및_초기화_테스트() {
    List<Integer> list = new DummyDoublyLinkedList<>();

    assertThat(list).isNotNull();
  }

  @ParameterizedTest
  @CsvSource({"11,22,33"})
  @DisplayName("DummyDoublyLinkedList 데이터 3개 저장 테스트")
  void DummyDoublyLinkedList_데이터_3개_저장_테스트(int firstElem, int secondElem, int thirdElem) {
    List<Integer> list = new DummyDoublyLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);

    int expectedSize = 3;
    int notContainsElem = 44;
    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.contains(firstElem)).isTrue();
    assertThat(list.contains(secondElem)).isTrue();
    assertThat(list.contains(thirdElem)).isTrue();
    assertThat(list.contains(notContainsElem)).isFalse();
    assertThat(list.get(0)).isEqualTo(firstElem);
    assertThat(list.get(1)).isEqualTo(secondElem);
    assertThat(list.get(2)).isEqualTo(thirdElem);
  }

  @ParameterizedTest
  @CsvSource({"11,22,33"})
  @DisplayName("DummyDoublyLinkedList 데이터 3개 저장 후 삭제 테스트")
  void DummyDoublyLinkedList_데이터_3개_저장_후_삭제_테스트(int firstElem, int secondElem, int thirdElem) {
    List<Integer> list = new DummyDoublyLinkedList<>();
    list.insert(firstElem);
    list.insert(secondElem);
    list.insert(thirdElem);

    list.remove(2);
    list.remove(1);

    int expectedSize = 1;
    int notContainsElem = 44;
    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(expectedSize);
    assertThat(list.contains(firstElem)).isTrue();
    assertThat(list.contains(secondElem)).isFalse();
    assertThat(list.contains(thirdElem)).isFalse();
    assertThat(list.contains(notContainsElem)).isFalse();
    assertThat(list.get(0)).isEqualTo(firstElem);
  }

  @Test
  @DisplayName("DummyDoublyLinkedList 예외 처리 테스트")
  void DummyDoublyLinkedList_예외_처리_테스트() {
    List<Integer> list = new DummyDoublyLinkedList<>();

    assertThat(list.get(3)).isNull();
    assertThat(list.remove(4)).isNull();
    assertThat(list.contains(null)).isFalse();
    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("DummyDoublyLinkedList 예외 처리 테스트2")
  void DummyDoublyLinkedList_예외_처리_테스트2() {
    List<Integer> list = new DummyDoublyLinkedList<>();

    list.insert(1);

    assertThat(list.get(3)).isNull();
    assertThat(list.remove(4)).isNull();
    assertThat(list.contains(null)).isFalse();
    assertThat(list.size()).isEqualTo(1);
    assertThat(list.isEmpty()).isFalse();
  }
}
