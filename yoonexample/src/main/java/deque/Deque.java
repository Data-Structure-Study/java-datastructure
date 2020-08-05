package deque;

/**
 * Deque 자료구조의 ADT, 인터페이스
 *
 * @param <E> 데이터의 파라미터 타입
 * @author dion
 */
public interface Deque<E> {

  /**
   * 덱에 저장된 데이터의 개수를 반환합니다.
   *
   * @return 데이터의 개수
   */
  int size();

  /**
   * 덱이 비어있는지 여부를 반환합니다.
   *
   * @return 덱이 비어있으면 true, 그렇지 않으면 false
   */
  boolean isEmpty();

  /**
   * 덱의 앞부분에 데이터를 추가합니다.
   *
   * @param data 저장할 데이터
   */
  void addFirst(E data);

  /**
   * 덱의 뒷부분에 데이터를 추가합니다.
   *
   * @param data 저장할 데이터
   */
  void addLast(E data);

  /**
   * 덱의 앞부분에 위치한 데이터를 제거합니다.
   *
   * @return 덱의 앞부분에 위치했던 데이터
   */
  E removeFirst();

  /**
   * 덱의 뒷부분에 위치한 데이터를 제거합니다.
   *
   * @return 덱의 뒷부분에 위치했던 데이터
   */
  E removeLast();

  /**
   * 덱의 앞부분에 위치한 데이터를 반환합니다.
   *
   * @return 덱의 앞부분에 위치한 데이터
   */
  E getFirst();

  /**
   * 덱의 뒷부분에 위치한 데이터를 반환합니다.
   *
   * @return 덱의 뒷부분에 위치한 데이터
   */
  E getLast();
}
