package tree.expressiontree;

import stack.ListStack;
import stack.Stack;
import tree.binarytree.LinkedTraversableBinaryTreeNode;
import tree.binarytree.TraversableBinaryTreeNode;

public class LinkedExpressionTree implements ExpressionTree {

  private TraversableBinaryTreeNode<Character> root;

  public LinkedExpressionTree(char[] postfixExpression) {
    Stack<TraversableBinaryTreeNode<Character>> stack = new ListStack<>();

    for (char expr : postfixExpression) {
      TraversableBinaryTreeNode<Character> node = new LinkedTraversableBinaryTreeNode<>(expr);
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
    return evaluateTree(this.root);
  }

  private int evaluateTree(TraversableBinaryTreeNode<Character> node) {
    TraversableBinaryTreeNode<Character> leftSubTree = node.getLeftSubTree();
    TraversableBinaryTreeNode<Character> rightSubTree = node.getRightSubTree();

    if (leftSubTree == null && rightSubTree == null) {
      return Character.getNumericValue(node.getData()); // 단말 노드는 피연산자임
    }

    int op1 = 0;
    int op2 = 0;
    if (leftSubTree != null) {
      op1 = evaluateTree(leftSubTree);
    }
    if (rightSubTree != null) {
      op2 = evaluateTree(rightSubTree);
    }

    switch (node.getData()) {
      case '+':
        return op1 + op2;
      case '-':
        return op1 - op2;
      case '*':
        return op1 * op2;
      case '/':
        if (op2 == 0) {
          throw new ArithmeticException("Can't be division by zero.");
        }
        return op1 / op2;
    }

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
