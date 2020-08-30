package graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

  Graph graph;

  @BeforeEach
  void setUp() {
    graph = new ListGrpah(5);
  }

  @Test
  void 그래프_초기화_테스트() {
    assertThat(graph).isNotNull();
  }

  @Test
  void 그래프_정점_연결_테스트() {
    graph.addEdge();
  }
}
