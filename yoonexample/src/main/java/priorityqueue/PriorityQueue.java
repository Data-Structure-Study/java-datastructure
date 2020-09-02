package priorityqueue;

/**
 * 우선순위 큐 인터페이스
 *
 * @param <E> 타입 파라미터
 */
public interface PriorityQueue<E> {

  /**
   * 해당 우선순위 큐가 비어있는지 여부를 반환합니다.
   *
   * @return 해당 우선순위 큐가 비어있는지 여부
   */
  boolean isEmpty();

  /**
   * 우선순위 큐에 데이터를 저장합니다.
   *
   * @param data 저장할 데이터
   */
  void enqueue(E data);

  /**
   * 우선순위 큐에서 우선순위가 가장 높은 데이터를 제거합니다.<br>이 메소드는 데이터가 최소 1개 이상 있을 때, 동작합니다.
   *
   * @return 우선순위가 가장 높은 데이터
   */
  E dequeue();

  /**
   * 우선순위 큐에 저장되어 있는 데이터의 수를 반환합니다.
   *
   * @return 우선순위 큐에 저장되어 있는 데이터의 수
   */
  int size();
}
