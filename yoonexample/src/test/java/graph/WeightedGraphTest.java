package graph;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedGraphTest {

  WeightedGraph graph;

  @BeforeEach
  void setUp() {
    this.graph = new ListWeightGraph(7, Point.class);
  }

  @Test
  void 가중치_그래프_초기화_테스트() {
    assertThat(this.graph).isNotNull();
  }

  @Test
  void 가중치_없이_생성하면_UnsupportedOperationException_발생_테스트() {
    assertThatThrownBy(() -> graph.addEdge(Point.A, Point.B))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void 가중치_그래프_정점_연결_테스트() {
    graph.addEdge(Point.A, Point.B, 9);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B\nB: A\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo("(A-B), w: 9\n");

    graph.addEdge(Point.B, Point.C, 2);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B\nB: A C\nC: B\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo("(A-B), w: 9\n(B-C), w: 2\n");

    graph.addEdge(Point.A, Point.C, 12);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B C\nB: A C\nC: B A\n");
    assertThat(graph.showGraphEdgeWeightInfo())
        .isEqualTo("(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n");

    graph.addEdge(Point.A, Point.D, 8);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B C D\nB: A C\nC: B A\nD: A\n");
    assertThat(graph.showGraphEdgeWeightInfo())
        .isEqualTo("(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n");

    graph.addEdge(Point.D, Point.C, 6);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B C D\nB: A C\nC: B A D\nD: A C\n");
    assertThat(graph.showGraphEdgeWeightInfo())
        .isEqualTo("(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n");

    graph.addEdge(Point.A, Point.F, 11);
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: B C D F\nB: A C\nC: B A D\nD: A C\nF: A\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo(
        "(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n(A-F), w: 11\n");

    graph.addEdge(Point.F, Point.D, 4);
    assertThat(graph.showGraphEdgeInfo())
        .isEqualTo("A: B C D F\nB: A C\nC: B A D\nD: A C F\nF: A D\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo(
        "(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n(A-F), w: 11\n(F-D), w: 4\n");

    graph.addEdge(Point.D, Point.E, 3);
    assertThat(graph.showGraphEdgeInfo())
        .isEqualTo("A: B C D F\nB: A C\nC: B A D\nD: A C F E\nE: D\nF: A D\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo(
        "(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n(A-F), w: 11\n(F-D), w: 4\n(D-E), w: 3\n");

    graph.addEdge(Point.E, Point.C, 7);
    assertThat(graph.showGraphEdgeInfo())
        .isEqualTo("A: B C D F\nB: A C\nC: B A D E\nD: A C F E\nE: D C\nF: A D\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo(
        "(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n(A-F), w: 11\n(F-D), w: 4\n(D-E), w: 3\n(E-C), w: 7\n");

    graph.addEdge(Point.F, Point.E, 13);
    assertThat(graph.showGraphEdgeInfo())
        .isEqualTo("A: B C D F\nB: A C\nC: B A D E\nD: A C F E\nE: D C F\nF: A D E\n");
    assertThat(graph.showGraphEdgeWeightInfo()).isEqualTo(
        "(A-B), w: 9\n(B-C), w: 2\n(A-C), w: 12\n(A-D), w: 8\n(D-C), w: 6\n(A-F), w: 11\n(F-D), w: 4\n(D-E), w: 3\n(E-C), w: 7\n(F-E), w: 13\n");
  }

  @Test
  void 가중치_그래프_MST변환_테스트() {
    graph.addEdge(Point.A, Point.B, 9);
    graph.addEdge(Point.B, Point.C, 2);
    graph.addEdge(Point.A, Point.C, 12);
    graph.addEdge(Point.A, Point.D, 8);
    graph.addEdge(Point.D, Point.C, 6);
    graph.addEdge(Point.A, Point.F, 11);
    graph.addEdge(Point.F, Point.D, 4);
    graph.addEdge(Point.D, Point.E, 3);
    graph.addEdge(Point.E, Point.C, 7);
    graph.addEdge(Point.F, Point.E, 13);

    graph.convertToMST(new KruskalAlgorithm());
    assertThat(graph.showGraphEdgeInfo()).isEqualTo("A: D\nB: C\nC: B D\nD: A C E F\nE: D\nF: D\n");
    assertThat(graph.showGraphEdgeWeightInfo())
        .isEqualTo("(A-D), w: 8\n(D-C), w: 6\n(F-D), w:4\n(D-E), w:3\n(B-C), w:2\n");
  }

  private enum Point {
    A, B, C, D, E, F, G, H, I, J
  }
}
