package queue;

/**
 * Queue 자료구조의 ADT, 인터페이스
 *
 * @param <E> 데이터의 파라미터 타입
 * @author dion
 */
public interface Queue<E> {

  /**
   * 큐에 저장된 데이터의 개수를 반환합니다.
   *
   * @return 데이터의 개수
   */
  int size();

  /**
   * 큐가 비어있는지 여부를 반환합니다.
   *
   * @return 큐가 비어있으면 true, 그렇지 않으면 false
   */
  boolean isEmpty();

  /**
   * 큐에 파라미터로 전달된 데이터를 마지막에 저장합니다.
   *
   * @param data 저장할 데이터
   */
  void enqueue(E data);

  /**
   * 큐의 처음에 위치한 데이터를 꺼냅니다. 이 함수를 호출하기 위해서는 데이터가 하나 이상 있음이 보장되어야 합니다.
   *
   * @return 처음에 위치했던 데이터
   */
  E dequeue();

  /**
   * 큐의 처음에 위치한 데이터를 확인합니다. 이 함수를 호출하기 위해서는 데이터가 하나 이상 있음이 보장되어야 합니다.
   *
   * @return 처음에 위치한 데이터
   */
  E peek();
}
