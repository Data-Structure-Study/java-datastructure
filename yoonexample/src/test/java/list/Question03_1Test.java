package list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Question03_1Test {

  @Test
  void 리스트_자료구조_활용() {
    List<Integer> list = new ArrayList<>();

    for (int i = 1; i < 10; i++) {
      list.insert(i);
    }

    for (int i = 0; i < list.size(); i++) {
      assertThat(list.get(i)).isEqualTo(i + 1);
    }

    int actual = 0;
    int expected = 45;

    for (int i = 0; i < list.size(); i++) {
      actual += list.get(i);
    }

    assertThat(actual).isEqualTo(expected);

    for (int i = 0; i < list.size(); i++) {
      int data = list.get(i);
      if (data % 2 == 0 || data % 3 == 0) {
        list.remove(i);
        i--;
      }
    }

    // 1, 5, 7
    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(1)).isEqualTo(5);
    assertThat(list.get(2)).isEqualTo(7);
  }
}
