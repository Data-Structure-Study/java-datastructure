package heap;

import java.util.Comparator;

public class ArrayUsefulHeap<E> implements UsefulHeap<E> {

  private static final int INITIAL_CAPACITY = 100 + 1;

  private int numOfData;
  private Object[] heapArr;
  // 첫번째 인자가 크면 양수, 작으면 음수, 같으면 0을 반환한다.
  private Comparator<E> comp;

  public ArrayUsefulHeap(Comparator<E> comparator) {
    this.heapArr = new Object[INITIAL_CAPACITY];
    this.comp = comparator;
  }

  @Override
  public boolean isEmpty() {
    return this.numOfData == 0;
  }

  @Override
  public void insert(E data) {

  }

  @Override
  public E delete() {
    return null;
  }

}
