package heap;

/**
 * Comparator를 이용한 쓸만한 Heap 자료구조
 *
 * @param <E> 타입 파라미터
 */
public interface UsefulHeap<E> {

  /**
   * 해당 Heap이 비어있는지 여부를 반환합니다.
   *
   * @return 해당 Heap이 비어있으면 true, 아니라면 false
   */
  boolean isEmpty();

  /**
   * 해당 Heap에 데이터를 저장합니다. 우선순위는 Comparator로 결정합니다.
   *
   * @param data 저장할 데이터
   */
  void insert(E data);

  /**
   * 해당 Heap의 최우선순위 데이터를 제거합니다.
   *
   * @return 힙에 저장되어 있던 최우선순위 데이터
   */
  E delete();

  /**
   * 힙에 저장되어 있는 데이터의 수를 반환합니다.
   *
   * @return 힙에 저장되어 있는 데이터의 수
   */
  int size();
}
