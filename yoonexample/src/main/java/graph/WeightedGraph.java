package graph;

/**
 * 가중치 그래프의 인터페이스
 *
 * @author dion
 */
public interface WeightedGraph extends Graph {

  /**
   * 매개변수 fromV와 toV로 전달된 정점을 연결하는 간선에 가중치를 부여하여 그래프에 추가합니다.
   *
   * @param fromV  시작하는 정점
   * @param toV    도달하는 정점
   * @param weight 간선의 가중치
   */
  void addEdge(Enum<?> fromV, Enum<?> toV, int weight);

  /**
   * 그래프의 간선정보 및 가중치를 반환합니다.
   *
   * @return 그래프의 간선정보 및 가중치
   */
  String showGraphEdgeWeightInfo();

  /**
   * 크루스칼 알고리즘을 이용해 최소신장 트리로 변환합니다.
   */
  void convertToMST();
}
