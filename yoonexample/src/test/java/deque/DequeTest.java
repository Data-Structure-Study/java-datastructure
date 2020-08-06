package deque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.EmptyDequeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DequeTest {

  @Test
  @DisplayName("덱의_생성_및_초기화_테스트")
  void 덱의_생성_및_초기화_테스트() {
    Deque<Integer> deque = new LinkedLIstDeque<>();

    assertThat(deque).isNotNull();
    assertThat(deque.size()).isEqualTo(0);
    assertThat(deque.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("덱에_데이터_삽입_테스트")
  void 덱에_데이터_삽입_테스트() {
    Deque<Integer> deque = new LinkedLIstDeque<>();

    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);

    assertThat(deque).isNotNull();
    assertThat(deque.size()).isEqualTo(6);
    assertThat(deque.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("덱에_데이터_삽입_앞에서_삭제_테스트")
  void 덱에_데이터_삽입_앞에서_삭제_테스트() {
    Deque<Integer> deque = new LinkedLIstDeque<>();

    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);

    assertThat(deque).isNotNull();
    assertThat(deque.size()).isEqualTo(6);
    assertThat(deque.isEmpty()).isFalse();
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(1);
    assertThat(deque.size()).isEqualTo(5);
    assertThat(deque.getFirst()).isEqualTo(2);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(2);
    assertThat(deque.size()).isEqualTo(4);
    assertThat(deque.getFirst()).isEqualTo(3);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(3);
    assertThat(deque.size()).isEqualTo(3);
    assertThat(deque.getFirst()).isEqualTo(4);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(4);
    assertThat(deque.size()).isEqualTo(2);
    assertThat(deque.getFirst()).isEqualTo(5);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(5);
    assertThat(deque.size()).isEqualTo(1);
    assertThat(deque.getFirst()).isEqualTo(6);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeFirst()).isEqualTo(6);
    assertThat(deque.size()).isEqualTo(0);
    assertThat(deque.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("덱에_데이터_삽입_뒤에서_삭제_테스트")
  void 덱에_데이터_삽입_뒤에서_삭제_테스트() {
    Deque<Integer> deque = new LinkedLIstDeque<>();

    deque.addFirst(3);
    deque.addFirst(2);
    deque.addFirst(1);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);

    assertThat(deque).isNotNull();
    assertThat(deque.size()).isEqualTo(6);
    assertThat(deque.isEmpty()).isFalse();
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(6);
    assertThat(deque.removeLast()).isEqualTo(6);
    assertThat(deque.size()).isEqualTo(5);
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(5);
    assertThat(deque.removeLast()).isEqualTo(5);
    assertThat(deque.size()).isEqualTo(4);
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(4);
    assertThat(deque.removeLast()).isEqualTo(4);
    assertThat(deque.size()).isEqualTo(3);
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(3);
    assertThat(deque.removeLast()).isEqualTo(3);
    assertThat(deque.size()).isEqualTo(2);
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(2);
    assertThat(deque.removeLast()).isEqualTo(2);
    assertThat(deque.size()).isEqualTo(1);
    assertThat(deque.getFirst()).isEqualTo(1);
    assertThat(deque.getLast()).isEqualTo(1);
    assertThat(deque.removeLast()).isEqualTo(1);
    assertThat(deque.size()).isEqualTo(0);
    assertThat(deque.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("덱이_비어있을_때_예외_처리_테스트")
  void 덱이_비어있을_때_예외_처리_테스트() {
    Deque<Integer> deque = new LinkedLIstDeque<>();

    assertThat(deque).isNotNull();
    assertThat(deque.size()).isEqualTo(0);
    assertThat(deque.isEmpty()).isTrue();
    assertThatThrownBy(deque::getFirst).isInstanceOf(EmptyDequeException.class);
    assertThatThrownBy(deque::removeFirst).isInstanceOf(EmptyDequeException.class);
    assertThatThrownBy(deque::getLast).isInstanceOf(EmptyDequeException.class);
    assertThatThrownBy(deque::removeLast).isInstanceOf(EmptyDequeException.class);
  }
}
