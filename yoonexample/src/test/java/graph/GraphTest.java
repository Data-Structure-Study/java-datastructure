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

  @Test
  void dfsTest() {
    graph.addEdge(Point.A, Point.B);
    graph.addEdge(Point.A, Point.C);
    graph.addEdge(Point.A, Point.E);
    graph.addEdge(Point.B, Point.D);
    graph.addEdge(Point.B, Point.E);
    graph.addEdge(Point.C, Point.D);
    graph.addEdge(Point.D, Point.E);

    assertThat(graph.depthFirstSearch(Point.A)).isEqualTo("A E D C B");
    assertThat(graph.depthFirstSearch(Point.B)).isEqualTo("B E D C A");
    assertThat(graph.depthFirstSearch(Point.C)).isEqualTo("C D E B A");
    assertThat(graph.depthFirstSearch(Point.D)).isEqualTo("D E B A C");
    assertThat(graph.depthFirstSearch(Point.E)).isEqualTo("E D C A B");
  }

  private enum Point {
    A, B, C, D, E, F, G, H, I, J
  }
}
