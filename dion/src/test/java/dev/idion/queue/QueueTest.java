package dev.idion.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        fail("Not Implemented");
    }
}
