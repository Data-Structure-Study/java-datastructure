package priorityqueue;

import exception.EmptyQueueException;
import heap.ArrayUsefulHeap;
import heap.UsefulHeap;
import java.util.Comparator;

public class HeapPriorityQueue<E> implements PriorityQueue<E> {

  private final UsefulHeap<E> heap;

  public HeapPriorityQueue(Comparator<E> comparator) {
    this.heap = new ArrayUsefulHeap<>(comparator);
  }

  @Override
  public boolean isEmpty() {
    return this.heap.isEmpty();
  }

  @Override
  public void enqueue(E data) {
    this.heap.insert(data);
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    return this.heap.delete();
  }

  @Override
  public int size() {
    return this.heap.size();
  }
}
