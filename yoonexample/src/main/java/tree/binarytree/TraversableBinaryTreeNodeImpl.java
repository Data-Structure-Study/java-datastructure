package tree.binarytree;

public class TraversableBinaryTreeNodeImpl<E> implements TraversableBinaryTreeNode<E> {

  private final E data;
  private TraversableBinaryTreeNode<E> left;
  private TraversableBinaryTreeNode<E> right;

  public TraversableBinaryTreeNodeImpl(E data) {
    this.data = data;
  }

  @Override
  public E getData() {
    return this.data;
  }

  @Override
  public TraversableBinaryTreeNode<E> getLeftSubTree() {
    return this.left;
  }

  @Override
  public void setLeftSubTree(TraversableBinaryTreeNode<E> subTree) {
    this.left = subTree;
  }

  @Override
  public TraversableBinaryTreeNode<E> getRightSubTree() {
    return this.right;
  }

  @Override
  public void setRightSubTree(TraversableBinaryTreeNode<E> subTree) {
    this.right = subTree;
  }

  @Override
  public void preorderTraverse(StringBuilder sb) {
    sb.append(this.data.toString());
    if (this.left != null) {
      this.left.preorderTraverse(sb);
    }
    if (this.right != null) {
      this.right.preorderTraverse(sb);
    }
  }

  @Override
  public void inorderTraverse(StringBuilder sb) {
    if (this.left != null) {
      this.left.inorderTraverse(sb);
    }
    sb.append(this.data.toString());
    if (this.right != null) {
      this.right.inorderTraverse(sb);
    }
  }

  @Override
  public void postorderTraverse(StringBuilder sb) {
    if (this.left != null) {
      this.left.postorderTraverse(sb);
    }
    if (this.right != null) {
      this.right.postorderTraverse(sb);
    }
    sb.append(this.data.toString());
  }
}
