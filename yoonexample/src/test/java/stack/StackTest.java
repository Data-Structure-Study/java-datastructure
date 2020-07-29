package stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  @DisplayName("Array Stack의 생성 및 초기화")
  void arrayStack의_생성_및_초기화() {
    Stack<Integer> stack = new ArrayStack<>();

    assertThat(stack).isNotNull();
    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  @DisplayName("Array Stack에 데이터 5개 넣기")
  void arrayStack에_데이터_5개_넣기() {
    Stack<Integer> stack = new ArrayStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThat(stack).isNotNull();
    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.size()).isEqualTo(5);
  }

  @Test
  @DisplayName("Array Stack에 데이터 5개 넣고 뺴기")
  void arrayStack에_데이터_5개_넣고_빼기() {
    Stack<Integer> stack = new ArrayStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThat(stack).isNotNull();
    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.size()).isEqualTo(5);
    assertThat(stack.peek()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.peek()).isEqualTo(4);
    assertThat(stack.pop()).isEqualTo(4);
    assertThat(stack.peek()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.peek()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.peek()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isEqualTo(0);
  }
}
