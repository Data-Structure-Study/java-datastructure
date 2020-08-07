package tree.binarytree;

/**
 * 순회한 정보를 반환할 수 있는 이진 트리
 *
 * @param <E> 파라미터 타입
 */
public interface TraversableBinaryTreeNode<E> extends BinaryTreeNode<E> {

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
