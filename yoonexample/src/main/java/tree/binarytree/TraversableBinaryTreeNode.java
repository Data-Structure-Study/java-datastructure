package tree.binarytree;

/**
 * 순회한 정보를 반환할 수 있는 이진 트리
 *
 * @param <E> 파라미터 타입
 */
public interface TraversableBinaryTreeNode<E> {

  /**
   * 해당 노드에 저장된 데이터를 반환합니다.
   *
   * @return 저장된 데이터
   */
  E getData();

  /**
   * 해당 노드의 왼쪽 서브트리를 반환합니다.
   *
   * @return 왼쪽 서브트리
   */
  TraversableBinaryTreeNode<E> getLeftSubTree();

  /**
   * 왼쪽 서브트리를 등록합니다.
   *
   * @param subTree 대상이 될 노드
   */
  void setLeftSubTree(TraversableBinaryTreeNode<E> subTree);

  /**
   * 해당 노드의 오른쪽 서브트리를 반환합니다.
   *
   * @return 오른쪽 서브트리
   */
  TraversableBinaryTreeNode<E> getRightSubTree();

  /**
   * 오른쪽 서브트리를 등록합니다.
   *
   * @param subTree 대상이 될 노드
   */
  void setRightSubTree(TraversableBinaryTreeNode<E> subTree);

  /**
   * 전위 순회한 정보를 StringBuilder에 저장합니다.
   */
  void preorderTraverse(StringBuilder sb);

  /**
   * 중위 순회한 정보를 StringBuilder에 저장합니다.
   */
  void inorderTraverse(StringBuilder sb);

  /**
   * 후위 순회한 정보를 StringBuilder에 저장합니다.
   */
  void postorderTraverse(StringBuilder sb);
}
