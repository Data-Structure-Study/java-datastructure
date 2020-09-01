package graph;

/**
 * 간단한 그래프 자료구조의 인터페이스
 *
 * @author dion
 */
public interface Graph {

  /**
   * 매개변수 fromV와 toV로 전달된 정점을 연결하는 간선을 그래프에 추가합니다.
   *
   * @param fromV 시작하는 정점
   * @param toV   도달하는 정점
   */
  void addEdge(Enum<?> fromV, Enum<?> toV);

  /**
   * 그래프의 간선정보를 반환합니다.
   *
   * @return 그래프의 간선정보
   */
  String showGraphEdgeInfo();

  /**
   * startV를 기점으로 DFS를 수행한 결과를 반환합니다.
   *
   * @param startV DFS를 시작하는 정점
   * @return startV를 기점으로 하는 DFS 결과
   */
  String depthFirstSearch(Enum<?> startV);
}
