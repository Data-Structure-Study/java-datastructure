package table;

/**
 * 테이블 자료구조의 인터페이스, ADT
 *
 * @param <K> Key 타입에 사용될 타입 파라미터
 * @param <V> Value 타입에 사용될 타입 파라미터
 */
public interface Table<K, V> {

  /**
   * 테이블에 key로 value를 저장합니다.
   *
   * @param key   key 역할을 할 값
   * @param value value 역할을 할 값
   */
  void insert(K key, V value);

  /**
   * 테이블에 key값으로 저장되어있는 value를 찾습니다.
   *
   * @param key 검색에 사용될 key 값
   * @return key값에 해당하는 value, null 가능
   */
  V search(K key);

  /**
   * 테이블에 key값으로 저장되어있는 value를 찾아 테이블에서 제거하고, value를 반환합니다.
   *
   * @param key 검색에 사용될 key 값
   * @return key값에 해당하는 value, null 가능
   */
  V delete(K key);
}
