package dev.idion.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

class QueueTest {

    @Test
    @DisplayName("Queue creation test")
    void queueCreationTest() {
        Queue<Integer> queue = new Queue<>();
        assertThat(queue).isNotNull();
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Queue enqueue test")
    void queueEnqueueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("Queue dequeue test")
    void queueDequeueTest() {
        Queue<Integer> queue = new Queue<>();

        int expected = 1;
        queue.enqueue(expected);

        int actual = queue.dequeue();
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Queue clear test")
    void queueClearTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        assertThat(queue.size()).isEqualTo(4);
        assertThat(queue.isEmpty()).isFalse();

        queue.clear();
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Queue peek test")
    void queuePeekTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.peekFront()).isEqualTo(1);
        assertThat(queue.peekRear()).isEqualTo(2);
    }

    @Test
    @DisplayName("queue peek exception test")
    void queuePeekExceptionTest() {
        Queue<Integer> queue = new Queue<>();
        assertThatThrownBy(queue::peekFront).hasMessage("Queue가 비어있습니다.").isInstanceOf(NoSuchElementException.class);

        assertThatThrownBy(queue::peekRear).hasMessage("Queue가 비어있습니다.").isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("queue dequeue exception test")
    void queueDequeueExceptionTest() {
        fail("Not Implemented");
    }
}
