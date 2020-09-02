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
    int index = numOfData + 1;

    while (index != 1) {
      int parentIndex = getParentIndex(index);

      // 부모 노드와 비교했을 때, 부모노드보다 우선순위가 높다면 서로의 위치를 바꾼다.
      if (comp.compare(data, (E) this.heapArr[parentIndex]) > 0) {
        this.heapArr[index] = this.heapArr[parentIndex];
        index = parentIndex;
      } else {
        break;
      }
    }

    this.heapArr[index] = data;
    this.numOfData += 1;
  }

  @Override
  public E delete() {
    int rootIndex = 1;
    E retData = (E) this.heapArr[rootIndex]; // 루트노드에 존재하던 데이터
    E lastElement = (E) this.heapArr[this.numOfData]; // 마지막 노드

    int parentIndex = rootIndex; // 루트로 옮기는 것을 의미
    int childIndex = getHighPriorityChildIndex(parentIndex); // 더 우선순위인 자식노드

    while (childIndex > 0) { // 부모노드가 단말노드가 아니라면
      if (comp.compare(lastElement, (E) this.heapArr[childIndex]) >= 0) { // 마지막 노드가 우선순위가 높다면
        break;
      }
      this.heapArr[parentIndex] = this.heapArr[childIndex]; // 자식 노드와 부모노드의 위치를 변경
      parentIndex = childIndex;
      childIndex = getHighPriorityChildIndex(parentIndex);
    }

    this.heapArr[parentIndex] = lastElement; // 마지막에 위치했던 노드를 한 번에 옮긴다.
    this.numOfData -= 1;
    return retData;
  }

  @Override
  public int size() {
    return this.numOfData;
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
  private int getHighPriorityChildIndex(int currentIndex) {
    int leftChildIndex = this.getLeftChildIndex(currentIndex);
    if (leftChildIndex > this.numOfData) { // 존재하지 않는 노드라면
      return 0;
    }
    if (leftChildIndex == this.numOfData) { // 왼쪽노드가 마지막 노드라면
      return leftChildIndex;
    }

    int rightChildIndex = this.getRightChildIndex(currentIndex);
    E leftChildNode = (E) this.heapArr[leftChildIndex];
    E rightChildNode = (E) this.heapArr[rightChildIndex];

    // 우선순위는 낮은것이 더 우위이므로 왼쪽노드가 더 우선순위가 낮다면
    if (comp.compare(leftChildNode, rightChildNode) < 0) {
      return rightChildIndex;
    }
    return leftChildIndex;
  }
}
