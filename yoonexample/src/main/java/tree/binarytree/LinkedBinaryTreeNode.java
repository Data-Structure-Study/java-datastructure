package tree.binarytree;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

  private final E data;
  private BinaryTreeNode<E> left;
  private BinaryTreeNode<E> right;

  public LinkedBinaryTreeNode(E data) {
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

  @Override
  public BinaryTreeNode<E> removeLeftSubTree() {
    BinaryTreeNode<E> deleteNode = this.getLeftSubTree();
    this.left = null;
    return deleteNode;
  }

  @Override
  public BinaryTreeNode<E> removeRightSubTree() {
    BinaryTreeNode<E> deleteNode = this.getRightSubTree();
    this.right = null;
    return deleteNode;
  }

  @Override
  public void changeLeftSubTree(BinaryTreeNode<E> subTree) {
    this.left = subTree;
  }

  @Override
  public void changeRightSubTree(BinaryTreeNode<E> subTree) {
    this.right = subTree;
  }
}
