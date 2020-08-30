package graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

  Graph graph;

  @BeforeEach
  void setUp() {
    graph = new ListGraph(5, Point.class);
  }

  @Test
  void 그래프_초기화_테스트() {
    assertThat(graph).isNotNull();
  }

  @Test
  void 방향_그래프_정점_연결_테스트() {
    graph.addEdge(Point.A, Point.B);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B\nB: A\n");

    graph.addEdge(Point.A, Point.D);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B D\nB: A\nD: A\n");

    graph.addEdge(Point.B, Point.C);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B D\nB: A C\nC: B\nD: A\n");

    graph.addEdge(Point.C, Point.D);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B D\nB: A C\nC: B D\nD: A C\n");

    graph.addEdge(Point.D, Point.E);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B D\nB: A C\nC: B D\nD: A C E\nE: D\n");

    graph.addEdge(Point.E, Point.A);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B D E\nB: A C\nC: B D\nD: A C E\nE: D A\n");
  }

  private enum Point {
    A, B, C, D, E, F, G, H, I, J
  }
}
