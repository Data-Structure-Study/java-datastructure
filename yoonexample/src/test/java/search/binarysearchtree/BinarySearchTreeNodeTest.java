package search.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tree.binarytree.BinaryTreeNode;

class BinarySearchTreeNodeTest {

  @Test
  @DisplayName("이진_탐색_트리_테스트")
  void 이진_탐색_트리_테스트() {
    BinarySearchTreeNode<Integer> bstRoot = new LinkedBinarySearchTreeNode<>(5, (Comparator
        .comparingInt(o -> o)));
    BinaryTreeNode<Integer> searchNode;

    bstRoot.insert(1);
    bstRoot.insert(6);
    bstRoot.insert(2);
    bstRoot.insert(8);
    bstRoot.insert(3);
    bstRoot.insert(9);

    searchNode = bstRoot.search(1);
    assertThat(searchNode).isNotNull();
    assertThat(searchNode.getData()).isEqualTo(1);

    searchNode = bstRoot.search(4);
    assertThat(searchNode).isNull();

    searchNode = bstRoot.search(6);
    assertThat(searchNode).isNotNull();
    assertThat(searchNode.getData()).isEqualTo(6);

    searchNode = bstRoot.search(7);
    assertThat(searchNode).isNull();
  }

  @Test
  @DisplayName("이진_탐색_트리_제거_테스트")
  void 이진_탐색_트리_제거_테스트() {
    int RootNodeData = 5;
    int terminalNodeData = 2;
    int singleSubTreeNodeData = 6;
    int doubleSubTreeNodeData = 8;

    BinarySearchTreeNode<Integer> bstRoot = new LinkedBinarySearchTreeNode<>(RootNodeData,
        (Comparator
            .comparingInt(o -> o)));

    bstRoot.insert(doubleSubTreeNodeData);
    bstRoot.insert(1);
    bstRoot.insert(singleSubTreeNodeData);
    bstRoot.insert(4);
    bstRoot.insert(9);
    bstRoot.insert(3);
    bstRoot.insert(terminalNodeData);
    bstRoot.insert(7);

    assertThat(bstRoot.search(terminalNodeData).getData())
        .isEqualTo(bstRoot.remove(terminalNodeData).getData());
    assertThat(bstRoot.search(singleSubTreeNodeData).getData())
        .isEqualTo(bstRoot.remove(singleSubTreeNodeData).getData());
    assertThat(bstRoot.search(doubleSubTreeNodeData).getData())
        .isEqualTo(bstRoot.remove(doubleSubTreeNodeData).getData());
    assertThat(bstRoot.search(RootNodeData).getData())
        .isEqualTo(bstRoot.remove(RootNodeData).getData());
  }

  @Test
  @DisplayName("이진_탐색_트리_제거_테스트2")
  void 이진_탐색_트리_제거_테스트2() {
    BinarySearchTreeNode<Integer> bstRoot = new LinkedBinarySearchTreeNode<>(5,
        (Comparator
            .comparingInt(o -> o)));

    bstRoot.insert(8);
    bstRoot.insert(1);
    bstRoot.insert(6);
    bstRoot.insert(3);
    bstRoot.insert(2);
    bstRoot.insert(4);
    bstRoot.insert(9);
    bstRoot.insert(7);

    assertThat(bstRoot.search(1).getData())
        .isEqualTo(bstRoot.remove(1).getData());

    assertThat(bstRoot.search(3).getData())
        .isEqualTo(bstRoot.remove(3).getData());

    assertThat(bstRoot.search(5).getData())
        .isEqualTo(bstRoot.remove(5).getData());

    assertThat(bstRoot.search(4).getData())
        .isEqualTo(bstRoot.remove(4).getData());

    assertThat(bstRoot.search(7).getData())
        .isEqualTo(bstRoot.remove(7).getData());

    assertThat(bstRoot.search(9).getData())
        .isEqualTo(bstRoot.remove(9).getData());

    assertThat(bstRoot.search(8).getData())
        .isEqualTo(bstRoot.remove(8).getData());
  }
}
