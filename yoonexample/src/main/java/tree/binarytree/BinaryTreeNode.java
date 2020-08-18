package tree.binarytree;

/**
 * Tree 자료구조의 ADT, 인터페이스이자 Node의 인터페이스
 *
 * @param <E> 데이터의 파라미터 타입
 * @author dion
 */
public interface BinaryTreeNode<E> {

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
  BinaryTreeNode<E> getLeftSubTree();

  /**
   * 왼쪽 서브트리를 등록합니다.
   *
   * @param subTree 대상이 될 노드
   */
  void setLeftSubTree(BinaryTreeNode<E> subTree);

  /**
   * 해당 노드의 오른쪽 서브트리를 반환합니다.
   *
   * @return 오른쪽 서브트리
   */
  BinaryTreeNode<E> getRightSubTree();

  /**
   * 오른쪽 서브트리를 등록합니다.
   *
   * @param subTree 대상이 될 노드
   */
  void setRightSubTree(BinaryTreeNode<E> subTree);

  /**
   * 왼쪽 서브트리를 제거하고 반환합니다.
   *
   * @return 왼쪽 서브트리
   */
  BinaryTreeNode<E> removeLeftSubTree();

  /**
   * 오른쪽 서브트리를 제거하고 반환합니다.
   *
   * @return 오른쪽 서브트리
   */
  BinaryTreeNode<E> removeRightSubTree();

  /**
   * 왼쪽 서브트리를 입력된 서브트리로 대체합니다.
   *
   * @param subTree 왼쪽 서브트리를 대체할 서브트리
   */
  void changeLeftSubTree(BinaryTreeNode<E> subTree);

  /**
   * 오른쪽 서브트리를 입력된 서브트리로 대체합니다.
   *
   * @param subTree 오른쪽 서브트리를 대체할 서브트리
   */
  void changeRightSubTree(BinaryTreeNode<E> subTree);
}
