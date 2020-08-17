package search.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTreeNodeTest {

  @Test
  @DisplayName("이진_탐색_트리_테스트")
  void 이진_탐색_트리_테스트() {
    BinarySearchTreeNode<Integer> bstRoot = new LinkedBinarySearchTreeNode<>(5, (Comparator
        .comparingInt(o -> o)));
    BinarySearchTreeNode<Integer> searchNode;

    bstRoot.insert(1);
    bstRoot.insert(6);
    bstRoot.insert(2);
    bstRoot.insert(8);
    bstRoot.insert(3);
    bstRoot.insert(9);

    searchNode = bstRoot.search(1);
    assertThat(searchNode).isNotNull();
    assertThat(searchNode.getNodeData()).isEqualTo(1);

    searchNode = bstRoot.search(4);
    assertThat(searchNode).isNull();

    searchNode = bstRoot.search(6);
    assertThat(searchNode).isNotNull();
    assertThat(searchNode.getNodeData()).isEqualTo(6);

    searchNode = bstRoot.search(7);
    assertThat(searchNode).isNull();
  }
}
