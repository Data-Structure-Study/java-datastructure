package tree.binarytree;

/**
 * 순회한 정보를 반환할 수 있는 이진 트리
 *
 * @param <E> 파라미터 타입
 */
public interface TraverableBinaryTreeNode<E> extends BinaryTreeNode<E> {

  /**
   * 전위 순회한 정보를 반환합니다.
   *
   * @return 전위 순회 정보
   */
  String preorderTraverse(StringBuilder sb);

  /**
   * 중위 순회한 정보를 반환합니다.
   *
   * @return 중위 순회 정보
   */
  String inorderTraverse(StringBuilder sb);

  /**
   * 후위 순회한 정보를 반환합니다.
   *
   * @return 후위 순회 정보
   */
  String postorderTraverse(StringBuilder sb);
}
