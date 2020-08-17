package search.binarysearchtree;

/**
 * 이진 탐색 트리 자료구조의 ADT, 인터페이스이자 Node의 인터페이스
 *
 * @param <E> 데이터의 파라미터 타입
 * @author dion
 */
public interface BinarySearchTreeNode<E> {

  /**
   * 해당 노드에 저장된 데이터를 반환합니다.
   *
   * @return 노드에 저장된 데이터
   */
  E getNodeData();

  /**
   * 해당 데이터를 가지고 있는 노드를 찾습니다.
   *
   * @param data 찾으려고 하는 데이터
   * @return 해당 데이터를 가지고 있는 노드
   */
  BinarySearchTreeNode<E> search(E data);

  /**
   * 해당 데이터를 BST에 추가합니다.
   *
   * @param data BST에 저장할 데이터
   */
  void insert(E data);
}
