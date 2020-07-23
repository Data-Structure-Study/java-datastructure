package list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SortedListTest {

  @Test
  void SortedList의_생성_및_초기화() {
    SortedList<Integer> list = new DummyLinkedList<>();

    assertThat(list).isNotNull();
  }

  @Test
  void 데이터_5개_저장() {
    SortedList<Integer> list = new DummyLinkedList<>();
    list.insert(11);
    list.insert(11);
    list.insert(22);
    list.insert(22);
    list.insert(33);

    assertThat(list.size()).isEqualTo(5);
    assertThat(list.contains(null)).isFalse();
    assertThat(list.contains(11)).isTrue();
    assertThat(list.contains(22)).isTrue();
    assertThat(list.contains(33)).isTrue();
    assertThat(list.contains(44)).isFalse();
    assertThat(list.get(0)).isEqualTo(33);
    assertThat(list.get(1)).isEqualTo(22);
    assertThat(list.get(2)).isEqualTo(22);
    assertThat(list.get(3)).isEqualTo(11);
    assertThat(list.get(4)).isEqualTo(11);
  }

  @Test
  void 데이터_5개_저장_후_22인_데이터_모두_삭제() {
    SortedList<Integer> list = new DummyLinkedList<>();
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
    assertThat(list.get(0)).isEqualTo(33);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(11);
  }

  @Test
  void 정렬기준_설정_후_데이터_5개_저장_후_22인_데이터_모두_삭제() {
    SortedList<Integer> list = new DummyLinkedList<>();

    list.setSortRule((o1, o2) -> o2 - o1); // 내림차

    list.insert(11);
    list.insert(22);
    list.insert(11);
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
    assertThat(list.get(0)).isEqualTo(33);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(11);
  }
}
