package search.binarysearchtree;

import java.util.Comparator;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.LinkedBinaryTreeNode;

public class LinkedBinarySearchTreeNode<E> implements BinarySearchTreeNode<E> {

  private final Comparator<E> comparator;
  private BinaryTreeNode<E> node;

  public LinkedBinarySearchTreeNode(E data, Comparator<E> comparator) {
    this.node = new LinkedBinaryTreeNode<>(data);
    this.comparator = comparator;
  }

  @Override
  public BinaryTreeNode<E> search(E target) {
    BinaryTreeNode<E> curNode = this.node;

    while (curNode != null) {
      E curNodeData = curNode.getData();
      if (curNodeData.equals(target)) {
        return curNode;
      } else if (comparator.compare(curNodeData, target) > 0) {
        curNode = curNode.getLeftSubTree();
      } else {
        curNode = curNode.getRightSubTree();
      }
    }

    return null;
  }

  @Override
  public void insert(E data) {
    if (data == null) {
      return;
    }

    BinaryTreeNode<E> curNode = this.node;
    BinaryTreeNode<E> parentNode = null;

    while (curNode != null) { // 저장할 위치를 찾는다.
      E curNodeData = curNode.getData();
      if (data == curNodeData) { // 중복저장 허용 안함
        return;
      }

      parentNode = curNode;
      if (comparator.compare(curNodeData, data) > 0) {
        curNode = curNode.getLeftSubTree();
      } else {
        curNode = curNode.getRightSubTree();
      }
    }

    BinaryTreeNode<E> newNode = new LinkedBinaryTreeNode<>(data);
    if (comparator.compare(parentNode.getData(), data) > 0) { // 크기를 비교해서 원하는 위치에 저장한다.
      parentNode.setLeftSubTree(newNode);
    } else {
      parentNode.setRightSubTree(newNode);
    }
  }

  @Override
  public BinaryTreeNode<E> remove(E target) {
    BinaryTreeNode<E> rootDummyNode = new LinkedBinaryTreeNode<>(null);
    BinaryTreeNode<E> parentNode = rootDummyNode;
    BinaryTreeNode<E> currentNode = this.node;
    BinaryTreeNode<E> deleteNode;

    rootDummyNode.changeRightSubTree(this.node);

    while (currentNode != null && currentNode.getData() != target) {
      parentNode = currentNode;
      if (comparator.compare(target, currentNode.getData()) < 0) {
        currentNode = currentNode.getLeftSubTree();
      } else {
        currentNode = currentNode.getRightSubTree();
      }
    }

    if (currentNode == null) { // 삭제 대상이 조회되지 않은 경우
      return null;
    }

    deleteNode = currentNode;

    if (deleteNode.getLeftSubTree() == null && deleteNode.getRightSubTree() == null) {
      // 삭제 대상이 단말 노드인 경우
      if (parentNode.getLeftSubTree() == deleteNode) {
        parentNode.removeLeftSubTree();
      } else {
        parentNode.removeRightSubTree();
      }
    } else if (deleteNode.getLeftSubTree() == null || deleteNode.getRightSubTree() == null) {
      // 삭제 대상이 하나의 자식 노드를 갖는 경우
      BinaryTreeNode<E> childNode;

      if (deleteNode.getLeftSubTree() != null) {
        childNode = deleteNode.getLeftSubTree();
      } else {
        childNode = deleteNode.getRightSubTree();
      }

      if (parentNode.getLeftSubTree() == deleteNode) {
        parentNode.changeLeftSubTree(childNode);
      } else {
        parentNode.changeRightSubTree(childNode);
      }
    } else {
      // 둘 다 있는 경우
      BinaryTreeNode<E> moveNode = deleteNode.getRightSubTree();
      BinaryTreeNode<E> moveParentNode = deleteNode;

      // 삭제 대상의 대체 노드 찾기
      while (moveNode.getLeftSubTree() != null) {
        moveParentNode = moveNode;
        moveNode = moveNode.getLeftSubTree();
      }

      // 대체 노드의 부모 노드와 자식 노드 연결
      if (moveParentNode.getLeftSubTree() == moveNode) {
        moveParentNode.changeLeftSubTree(moveNode.getRightSubTree());
      } else {
        moveParentNode.changeRightSubTree(moveNode.getRightSubTree());
      }

      // 삭제 노드의 하위 노드를 대체 노드에 연결
      moveNode.changeLeftSubTree(deleteNode.getLeftSubTree());
      moveNode.changeRightSubTree(deleteNode.getRightSubTree());

      // 부모 노드의 하위 노드 변경
      if (parentNode.getLeftSubTree() != deleteNode) {
        parentNode.changeRightSubTree(moveNode);
      } else {
        parentNode.changeLeftSubTree(moveNode);
      }
    }

    if (rootDummyNode.getRightSubTree() != this.node) {
      this.node = rootDummyNode.getRightSubTree();
    }

    return deleteNode;
  }
}
