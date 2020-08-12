package heap;

public class ArraySimpleHeap<E> implements SimpleHeap<E> {

  private static final int INITIAL_CAPACITY = 100 + 1;

  private int numOfData;
  private Object[] heapArr = new Object[INITIAL_CAPACITY];

  @Override
  public boolean isEmpty() {
    return numOfData == 0;
  }

  @Override
  public void insert(E data, int priority) {

  }

  @Override
  public E delete() {
    return null;
  }
}
