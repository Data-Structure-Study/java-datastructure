package graph;

import java.util.Comparator;
import list.DummyDoublyLinkedList;
import list.List;
import priorityqueue.HeapPriorityQueue;
import priorityqueue.PriorityQueue;

public class ListWeightGraph implements WeightedGraph {

  private final List<Enum<?>>[] vertices;
  private final PriorityQueue<WeightEdge> edgePriorityQueue;

  public ListWeightGraph(int vertexCount, Class<? extends Enum<?>> clazz) {
    edgePriorityQueue = new HeapPriorityQueue<>(Comparator.comparingInt(o -> o.weight));
    Enum<?>[] enumConstants = clazz.getEnumConstants();
    int min = Math.min(vertexCount, enumConstants.length);

    this.vertices = new List[min];
    for (int i = 0; i < min; i++) {
      this.vertices[i] = new DummyDoublyLinkedList<>();
      this.vertices[i].insert(enumConstants[i]);
    }
  }

  @Override
  public void addEdge(Enum<?> fromV, Enum<?> toV, int weight) {

  }

  @Override
  public String showGraphEdgeWeightInfo() {
    return null;
  }

  @Override
  public void convertToMST(MSTConversionAlgorithm algorithm) {

  }

  @Override
  public void addEdge(Enum<?> fromV, Enum<?> toV) {
    throw new UnsupportedOperationException("이 메소드는 지원하지 않습니다.");
  }

  @Override
  public String showGraphEdgeInfo() {
    return null;
  }

  @Override
  public String depthFirstSearch(Enum<?> startV) {
    return null;
  }

  @Override
  public String breadthFirstSearch(Enum<?> startV) {
    return null;
  }

  private static class WeightEdge {

    private int weight;
    private Enum<?> fromVertex;
    private Enum<?> toVertex;
  }
}
