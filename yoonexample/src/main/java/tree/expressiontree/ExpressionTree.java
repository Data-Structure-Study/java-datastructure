package tree.expressiontree;

/**
 * 수식 트리 인터페이스
 */
public interface ExpressionTree {

  /**
   * 트리의 값을 계산합니다.
   *
   * @return 트리를 가지고 연산한 값
   */
  int evaluateTree();

  /**
   * 전위 표기법으로 표현합니다.
   *
   * @param sb 표기법이 저장될 공간
   */
  void prefixTypeExpression(StringBuilder sb);

  /**
   * 중위 표기법으로 표현합니다.
   *
   * @param sb 표기법이 저장될 공간
   */
  void infixTypeExpression(StringBuilder sb);

  /**
   * 후위 표기법으로 표현합니다.
   *
   * @param sb 표기법이 저장될 공간
   */
  void postfixTypeExpression(StringBuilder sb);
}
