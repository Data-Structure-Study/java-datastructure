package tree.expressiontree;

import stack.ListStack;
import stack.Stack;
import tree.binarytree.TraversableBinaryTreeNode;
import tree.binarytree.TraversableBinaryTreeNodeImpl;

public class ExpressionTreeImpl implements ExpressionTree {

  private TraversableBinaryTreeNode<Character> root;

  public ExpressionTreeImpl(char[] postfixExpression) {
    Stack<TraversableBinaryTreeNode<Character>> stack = new ListStack<>();

    for (char expr : postfixExpression) {
      TraversableBinaryTreeNode<Character> node = new TraversableBinaryTreeNodeImpl<>(expr);
      if (!Character.isDigit(expr)) { // 숫자가 아니라면, 연산자임
        node.setRightSubTree(stack.pop());
        node.setLeftSubTree(stack.pop());
      }

      stack.push(node);
    }

    this.root = stack.pop();
  }

  @Override
  public int evaluateTree() {
    return 0;
  }

  @Override
  public void prefixTypeExpression(StringBuilder sb) {
    this.root.preorderTraverse(sb);
  }

  @Override
  public void infixTypeExpression(StringBuilder sb) {
    this.root.inorderTraverse(sb);
  }

  @Override
  public void postfixTypeExpression(StringBuilder sb) {
    this.root.postorderTraverse(sb);
  }
}
