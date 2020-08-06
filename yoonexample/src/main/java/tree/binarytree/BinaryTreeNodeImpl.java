package tree.binarytree;

public class BinaryTreeNodeImpl<E> implements BinaryTreeNode<E> {

  private final E data;
  private BinaryTreeNode<E> left;
  private BinaryTreeNode<E> right;

  public BinaryTreeNodeImpl(E data) {
    this.data = data;
  }

  @Override
  public E getData() {
    return this.data;
  }

  @Override
  public BinaryTreeNode<E> getLeftSubTree() {
    return this.left;
  }

  @Override
  public void setLeftSubTree(BinaryTreeNode<E> subTree) {
    this.left = subTree;
  }

  @Override
  public BinaryTreeNode<E> getRightSubTree() {
    return this.right;
  }

  @Override
  public void setRightSubTree(BinaryTreeNode<E> subTree) {
    this.right = subTree;
  }
}
