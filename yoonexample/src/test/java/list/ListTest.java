package list;

import static org.assertj.core.api.Assertions.assertThat;

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
      }
    }

    assertThat(list.size()).isEqualTo(5);
    assertThat(list.get(0)).isEqualTo(11);
    assertThat(list.get(1)).isEqualTo(11);
    assertThat(list.get(2)).isEqualTo(33);
  }
}