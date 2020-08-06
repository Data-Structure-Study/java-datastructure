package tree.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeNodeTest {

  @Test
  @DisplayName("이진_트리_생성_및_초기화_테스트")
  void 이진_트리_생성_및_초기화_테스트() {
    BinaryTreeNode<Integer> bt = new BinaryTreeNodeImpl<>(1);

    assertThat(bt).isNotNull();
    assertThat(bt.getData()).isEqualTo(1);
    assertThat(bt.getLeftSubTree()).isNull();
    assertThat(bt.getRightSubTree()).isNull();
  }

  @Test
  @DisplayName("이진_트리_저장_및_출력_테스트")
  void 이진_트리_저장_및_출력_테스트() {
    BinaryTreeNode<Integer> bt1 = new BinaryTreeNodeImpl<>(1);
    BinaryTreeNode<Integer> bt2 = new BinaryTreeNodeImpl<>(2);
    BinaryTreeNode<Integer> bt3 = new BinaryTreeNodeImpl<>(3);
    BinaryTreeNode<Integer> bt4 = new BinaryTreeNodeImpl<>(4);

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
    assertThat(bt1.getLeftSubTree().getLeftSubTree().getData()).isEqualTo(2);
    assertThat(bt1.getLeftSubTree().getRightSubTree().getData()).isNull();
  }
}
