package queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.EmptyQueueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {

  @Test
  @DisplayName("배열_기반_큐_생성_테스트")
  void 배열_기반_큐_생성_테스트() {
    Queue<Integer> queue = new ArrayQueue<>();

    assertThat(queue).isNotNull();
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isEqualTo(0);
  }

  @Test
  @DisplayName("배열_기반_큐_생성_테스트")
  void 배열_기반_큐_EmptyQueueException_테스트() {
    Queue<Integer> queue = new ArrayQueue<>();

    assertThat(queue).isNotNull();
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isEqualTo(0);
    assertThatThrownBy(queue::dequeue).isInstanceOf(EmptyQueueException.class);
    assertThatThrownBy(queue::peek).isInstanceOf(EmptyQueueException.class);
  }

  @Test
  @DisplayName("배열_기반_큐_데이터_저장_테스트")
  void 배열_기반_큐_데이터_저장_테스트() {
    Queue<Integer> queue = new ArrayQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    assertThat(queue).isNotNull();
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(5);
  }

  @Test
  @DisplayName("배열_기반_큐_데이터_저장_후_제거_테스트")
  void 배열_기반_큐_데이터_저장_후_제거_테스트() {
    Queue<Integer> queue = new ArrayQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    assertThat(queue).isNotNull();
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.peek()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.peek()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.peek()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.peek()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.peek()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isEqualTo(0);
  }
}
