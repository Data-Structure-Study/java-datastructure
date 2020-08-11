package tree.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TraversableBinaryTreeNodeTest {

  @Test
  @DisplayName("순회_가능한_이진_트리_생성_및_초기화_테스트")
  void 순회_가능한_이진_트리_생성_및_초기화_테스트() {
    TraversableBinaryTreeNode<Integer> bt = new LinkedTraversableBinaryTreeNode<>(1);

    assertThat(bt).isNotNull();
    assertThat(bt.getData()).isEqualTo(1);
    assertThat(bt.getLeftSubTree()).isNull();
    assertThat(bt.getRightSubTree()).isNull();
  }

  @Test
  @DisplayName("순회_가능한_이진_트리_저장_및_출력_테스트")
  void 순회_가능한_이진_트리_저장_및_출력_테스트() {
    TraversableBinaryTreeNode<Integer> bt1 = new LinkedTraversableBinaryTreeNode<>(1);
    TraversableBinaryTreeNode<Integer> bt2 = new LinkedTraversableBinaryTreeNode<>(2);
    TraversableBinaryTreeNode<Integer> bt3 = new LinkedTraversableBinaryTreeNode<>(3);
    TraversableBinaryTreeNode<Integer> bt4 = new LinkedTraversableBinaryTreeNode<>(4);

    bt1.setLeftSubTree(bt2);
    bt1.setRightSubTree(bt3);
    bt2.setLeftSubTree(bt4);

    assertThat(bt1).isNotNull();
    assertThat(bt2).isNotNull();
    assertThat(bt3).isNotNull();
    assertThat(bt4).isNotNull();
    assertThat(bt1.getData()).isEqualTo(1);
    assertThat(bt2.getData()).isEqualTo(2);
    assertThat(bt3.getData()).isEqualTo(3);
    assertThat(bt4.getData()).isEqualTo(4);
    assertThat(bt1.getLeftSubTree().getData()).isEqualTo(2);
    assertThat(bt1.getRightSubTree().getData()).isEqualTo(3);
    assertThat(bt1.getLeftSubTree().getLeftSubTree().getData()).isEqualTo(4);
    assertThat(bt1.getLeftSubTree().getRightSubTree()).isNull();
  }

  @Test
  @DisplayName("순회_가능한_이진_트리_전위_순회_테스트")
  void 순회_가능한_이진_트리_전위_순회_테스트() {
    TraversableBinaryTreeNode<Integer> bt1 = new LinkedTraversableBinaryTreeNode<>(1);
    TraversableBinaryTreeNode<Integer> bt2 = new LinkedTraversableBinaryTreeNode<>(2);
    TraversableBinaryTreeNode<Integer> bt3 = new LinkedTraversableBinaryTreeNode<>(3);
    TraversableBinaryTreeNode<Integer> bt4 = new LinkedTraversableBinaryTreeNode<>(4);

    bt1.setLeftSubTree(bt2);
    bt1.setRightSubTree(bt3);
    bt2.setLeftSubTree(bt4);

    String expected = "1243";
    StringBuilder sb = new StringBuilder();
    bt1.preorderTraverse(sb);

    assertThat(sb.toString()).isEqualTo(expected);
  }

  @Test
  @DisplayName("순회_가능한_이진_트리_중위_순회_테스트")
  void 순회_가능한_이진_트리_중위_순회_테스트() {
    TraversableBinaryTreeNode<Integer> bt1 = new LinkedTraversableBinaryTreeNode<>(1);
    TraversableBinaryTreeNode<Integer> bt2 = new LinkedTraversableBinaryTreeNode<>(2);
    TraversableBinaryTreeNode<Integer> bt3 = new LinkedTraversableBinaryTreeNode<>(3);
    TraversableBinaryTreeNode<Integer> bt4 = new LinkedTraversableBinaryTreeNode<>(4);

    bt1.setLeftSubTree(bt2);
    bt1.setRightSubTree(bt3);
    bt2.setLeftSubTree(bt4);

    String expected = "4213";
    StringBuilder sb = new StringBuilder();
    bt1.inorderTraverse(sb);

    assertThat(sb.toString()).isEqualTo(expected);
  }

  @Test
  @DisplayName("순회_가능한_이진_트리_후위_순회_테스트")
  void 순회_가능한_이진_트리_후위_순회_테스트() {
    TraversableBinaryTreeNode<Integer> bt1 = new LinkedTraversableBinaryTreeNode<>(1);
    TraversableBinaryTreeNode<Integer> bt2 = new LinkedTraversableBinaryTreeNode<>(2);
    TraversableBinaryTreeNode<Integer> bt3 = new LinkedTraversableBinaryTreeNode<>(3);
    TraversableBinaryTreeNode<Integer> bt4 = new LinkedTraversableBinaryTreeNode<>(4);

    bt1.setLeftSubTree(bt2);
    bt1.setRightSubTree(bt3);
    bt2.setLeftSubTree(bt4);

    String expected = "4231";
    StringBuilder sb = new StringBuilder();
    bt1.postorderTraverse(sb);

    assertThat(sb.toString()).isEqualTo(expected);
  }
}
