package search.binarysearchtree;

import tree.binarytree.BinaryTreeNode;

/**
 * 이진 탐색 트리 자료구조의 ADT, 인터페이스이자 Node의 인터페이스
 *
 * @param <E> 데이터의 파라미터 타입
 * @author dion
 */
public interface BinarySearchTreeNode<E> {

  /**
   * 해당 데이터를 가지고 있는 노드를 찾습니다.
   *
   * @param target 찾으려고 하는 데이터
   * @return 해당 데이터를 가지고 있는 노드
   */
  BinaryTreeNode<E> search(E target);

  /**
   * 해당 데이터를 BST에 추가합니다.
   *
   * @param data BST에 저장할 데이터
   */
  void insert(E data);

  /**
   * 해당 데이터를 BST에서 제거하고 해당 데이터를 저장한 노드를 반환합니다.
   *
   * @param target 제거할 데이터
   * @return 제거된 데이터를 저장한 노드
   */
  BinaryTreeNode<E> remove(E target);
}
