package tree.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeNodeTest {

  private BinaryTreeNode<Integer> bt1;
  private BinaryTreeNode<Integer> bt2;
  private BinaryTreeNode<Integer> bt3;
  private BinaryTreeNode<Integer> bt4;
  private BinaryTreeNode<Integer> bt5;

  @BeforeEach
  void setUp() {
    bt1 = new LinkedBinaryTreeNode<>(1);
    bt2 = new LinkedBinaryTreeNode<>(2);
    bt3 = new LinkedBinaryTreeNode<>(3);
    bt4 = new LinkedBinaryTreeNode<>(4);
    bt5 = new LinkedBinaryTreeNode<>(5);

    bt1.setLeftSubTree(bt2);
    bt1.setRightSubTree(bt3);
    bt2.setLeftSubTree(bt4);
  }

  @Test
  @DisplayName("이진_트리_생성_및_초기화_테스트")
  void 이진_트리_생성_및_초기화_테스트() {
    assertThat(bt5).isNotNull();
    assertThat(bt5.getData()).isEqualTo(5);
    assertThat(bt5.getLeftSubTree()).isNull();
    assertThat(bt5.getRightSubTree()).isNull();
  }

  @Test
  @DisplayName("이진_트리_저장_및_출력_테스트")
  void 이진_트리_저장_및_출력_테스트() {
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
  @DisplayName("이진_트리_제거_테스트")
  void 이진_트리_제거_테스트() {
    assertThat(bt1.removeLeftSubTree()).isSameAs(bt2);
    assertThat(bt1.removeRightSubTree()).isSameAs(bt3);
    assertThat(bt1.getLeftSubTree()).isNull();
    assertThat(bt1.getRightSubTree()).isNull();
  }

  @Test
  @DisplayName("이진_트리_대체_테스트")
  void 이진_트리_대체_테스트() {
    assertThat(bt1.getLeftSubTree()).isSameAs(bt2);
    assertThat(bt1.getRightSubTree()).isSameAs(bt3);

    bt1.changeLeftSubTree(bt3);
    assertThat(bt1.getLeftSubTree()).isSameAs(bt3);

    bt1.changeRightSubTree(bt2);
    assertThat(bt1.getRightSubTree()).isSameAs(bt2);
  }
}
