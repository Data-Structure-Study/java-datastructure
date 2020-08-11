package heap;

/**
 * 우선순위를 기준으로 하는 Heap 자료구조
 *
 * @param <E> 타입 파라미터
 */
public interface SimpleHeap<E> {

  /**
   * 해당 Heap이 비어있는지 여부를 반환합니다.
   *
   * @return 해당 Heap이 비어있으면 true, 아니라면 false
   */
  boolean isEmpty();

  /**
   * 해당 Heap에 데이터를 저장합니다.
   *
   * @param data     저장할 데이터
   * @param priority 저장할 데이터의 우선순위(작을 수록 높은 우선순위)
   */
  void insert(E data, int priority);

  /**
   * 해당 Heap의 최우선순위 데이터를 제거합니다.
   *
   * @return 힙에 저장되어 있던 최우선순위 데이터
   */
  E delete();
}
