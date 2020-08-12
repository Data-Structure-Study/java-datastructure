package heap;

public class ArraySimpleHeap<E> implements SimpleHeap<E> {

  private static final int INITIAL_CAPACITY = 100 + 1;

  private int numOfData;
  private HeapElement<E>[] heapArr;

  public ArraySimpleHeap() {
    this.heapArr = new HeapElement[INITIAL_CAPACITY];
  }

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

  /**
   * 부모 노드의 인덱스 반환 요청
   *
   * @param currentIndex 현재 자식 노드의 인덱스
   * @return 부모노드의 인덱스
   */
  private int getParentIndex(int currentIndex) {
    return currentIndex / 2;
  }

  /**
   * 왼쪽 자식 노드의 인덱스 반환 요청
   *
   * @param parentIndex 부모 노드의 인덱스
   * @return 왼쪽 자식 노드의 인덱스
   */
  private int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2;
  }

  /**
   * 오른쪽 자식 노드의 인덱스 반환 요청
   *
   * @param parentIndex 부모 노드의 인덱스
   * @return 오른쪽 자식 노드의 인덱스
   */
  private int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  /**
   * 두 개의 자식 노드 중 우선순위가 더 높은 자식의 인덱스 반환 요청
   *
   * @param currentIndex 판단의 기준이 되는 노드
   * @return 우선순위가 더 높은 자식 노드의 인덱스
   */
  private int getHighPrioirtyChildIndex(int currentIndex) {
    int leftChildIndex = this.getLeftChildIndex(currentIndex);
    if (leftChildIndex > this.numOfData) { // 존재하지 않는 노드라면
      return 0;
    }
    if (leftChildIndex == this.numOfData) { // 왼쪽노드가 마지막 노드라면
      return leftChildIndex;
    }

    int rightChildIndex = this.getRightChildIndex(currentIndex);
    int leftChildNodePriority = this.heapArr[leftChildIndex].priority;
    int rightChildNodePriority = this.heapArr[rightChildIndex].priority;

    // 우선순위는 낮은것이 더 우위이므로 왼쪽노드가 더 우선순위가 낮다면
    if (leftChildNodePriority > rightChildNodePriority) {
      return rightChildIndex;
    }
    return leftChildIndex;
  }

  private static class HeapElement<T> {

    private final T data;
    private final int priority;

    public HeapElement(T data, int priority) {
      this.data = data;
      this.priority = priority;
    }
  }
}
