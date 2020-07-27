package list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListTest {

  @Test
  void ArrayList의_생성_및_초기화() {
    List<Integer> list = new ArrayList<>();

    assertThat(list).isNotNull();
  }

  @Test
  void 데이터_5개_저장() {
    List<Integer> list = new ArrayList<>();
    list.insert(11);
    list.insert(11);
    list.insert(22);
    list.insert(22);
    list.insert(33);

    assertThat(list.size()).isEqualTo(5);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(22);
    assertThat(list.get(3)).isEqualTo(22);
    assertThat(list.get(4)).isEqualTo(33);
  }

  @Test
  void 데이터_5개_저장_후_22인_데이터_모두_삭제() {
    List<Integer> list = new ArrayList<>();
    list.insert(11);
    list.insert(11);
    list.insert(22);
    list.insert(22);
    list.insert(33);

    // Iterable을 구현하면 enhanced for loop를 사용할 수 있습니다.
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 22) {
        list.remove(i);
        i--; // 삭제되면 index가 조정되므로 해당 index부터 다시 확인해야 합니다.
      }
    }

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(33);
  }

  @Test
  void CircularLinkedList의_생성_및_초기화() {
    List<Integer> list = new CircularLinkedList<>();

    assertThat(list).isNotNull();
  }

  @Test
  void CircularLinkedList에_데이터_5개_저장() {
    List<Integer> list = new CircularLinkedList<>();
    list.insert(11);
    list.insert(11);
    list.insert(22);
    list.insert(22);
    list.insert(33);

    assertThat(list.size()).isEqualTo(5);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(22);
    assertThat(list.get(3)).isEqualTo(22);
    assertThat(list.get(4)).isEqualTo(33);
    assertThat(list.get(5)).isEqualTo(11);
  }

  @Test
  void CircularLinkedList에_데이터_5개_저장_후_22인_데이터_모두_삭제() {
    List<Integer> list = new CircularLinkedList<>();
    list.insert(11);
    list.insert(11);
    list.insert(22);
    list.insert(22);
    list.insert(33);

    // Iterable을 구현하면 enhanced for loop를 사용할 수 있습니다.
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 22) {
        list.remove(i);
        i--; // 삭제되면 index가 조정되므로 해당 index부터 다시 확인해야 합니다.
      }
    }

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(33);
    assertThat(list.get(3)).isEqualTo(11);
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
  @DisplayName("DoublyLinkedList의 생성 및 초기화 테스트")
  void DoublyLinkedList의_생성_및_초기화_테스트() {
    List<Integer> list = new DoublyLinkedList<>();

    assertThat(list).isNotNull();
  }

  @Test
  @DisplayName("DoublyLinkedList 데이터 3개 저장 테스트")
  void DoublyLinkedList_데이터_3개_저장_테스트() {
    List<Integer> list = new DoublyLinkedList<>();

    list.insert(11);
    list.insert(22);
    list.insert(33);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(22);
    assertThat(list.get(2)).isEqualTo(33);
  }
}
}
