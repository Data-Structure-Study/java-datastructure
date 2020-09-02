package graph;

import java.util.Comparator;
import java.util.StringJoiner;
import list.DummyDoublyLinkedList;
import list.List;
import priorityqueue.HeapPriorityQueue;
import priorityqueue.PriorityQueue;
import queue.LinkedListQueue;
import queue.Queue;
import stack.ListStack;
import stack.Stack;

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
    WeightEdge edge = new WeightEdge(weight, fromV, toV);
    vertices[fromV.ordinal()].insert(toV);
    vertices[toV.ordinal()].insert(fromV);

    edgePriorityQueue.enqueue(edge);
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
    StringBuilder sb = new StringBuilder();

    for (List<Enum<?>> vertex : vertices) {
      if (vertex.size() > 1) {
        for (int i = 0; i < vertex.size(); i++) {
          sb.append(vertex.get(i));
          if (i == 0) {
            sb.append(": ");
          } else if (i < vertex.size() - 1) {
            sb.append(" ");
          }
        }
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  @Override
  public String depthFirstSearch(Enum<?> startV) {
    boolean[] visited = new boolean[vertices.length];
    StringJoiner sj = new StringJoiner(" ");
    Stack<Enum<?>> vertexStack = new ListStack<>();
    vertexStack.push(startV);

    while (!vertexStack.isEmpty()) {
      Enum<?> visitV = vertexStack.pop();

      if (visitVertex(visited, visitV)) {
        sj.add(visitV.toString());
      }
      List<Enum<?>> vertexList = vertices[visitV.ordinal()];
      for (int i = 0; i < vertexList.size(); i++) {
        Enum<?> vertex = vertexList.get(i);
        if (!visited[vertex.ordinal()]) {
          vertexStack.push(vertex);
        }
      }
    }

    return sj.toString();
  }

  @Override
  public String breadthFirstSearch(Enum<?> startV) {
    boolean[] visited = new boolean[vertices.length];
    StringJoiner sj = new StringJoiner(" ");
    Queue<Enum<?>> vertexQueue = new LinkedListQueue<>();
    vertexQueue.enqueue(startV);

    while (!vertexQueue.isEmpty()) {
      Enum<?> visitV = vertexQueue.dequeue();

      if (visitVertex(visited, visitV)) {
        sj.add(visitV.toString());
      }

      List<Enum<?>> vertexList = vertices[visitV.ordinal()];
      for (int i = 0; i < vertexList.size(); i++) {
        Enum<?> vertex = vertexList.get(i);
        if (!visited[vertex.ordinal()]) {
          vertexQueue.enqueue(vertex);
        }
      }

    }

    return sj.toString();
  }

  private boolean visitVertex(boolean[] visited, Enum<?> vertex) {
    if (visited[vertex.ordinal()]) {
      return false;
    }
    visited[vertex.ordinal()] = true;
    return true;
  }

  private static class WeightEdge {

    private final int weight;
    private final Enum<?> fromVertex;
    private final Enum<?> toVertex;

    public WeightEdge(int weight, Enum<?> fromVertex, Enum<?> toVertex) {
      this.weight = weight;
      this.fromVertex = fromVertex;
      this.toVertex = toVertex;
    }
  }
}
