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
    List<WeightEdge> weightEdgeList = new DummyDoublyLinkedList<>();
    StringBuilder sb = new StringBuilder();

    while (!this.edgePriorityQueue.isEmpty()) {
      WeightEdge edge = this.edgePriorityQueue.dequeue();
      weightEdgeList.insert(edge);
      sb.append(edge.showEdgeInfo()).append("\n");
    }

    for (int i = 0; i < weightEdgeList.size(); i++) {
      this.edgePriorityQueue.enqueue(weightEdgeList.get(i));
    }

    return sb.toString();
  }

  @Override
  public void convertToMST() {
    int vertexCount = this.vertices.length;
    int edgeCount = this.edgePriorityQueue.size() + 1;
    List<WeightEdge> edges = new DummyDoublyLinkedList<>();

    // MST가 될 때까지 while문을 반복
    while (edgeCount != vertexCount) {
      WeightEdge edge = this.edgePriorityQueue.dequeue();
      removeEdge(edge.fromVertex, edge.toVertex); // 그래프에서 제거해본다.
      edgeCount--;

      if (!isConnectedWith(edge.fromVertex, edge.toVertex)) { // 연결되어 있지 않으면 복구
        recoverEdge(edge);
        edges.insert(edge);
        edgeCount++;
      }
    }

    // 간선 정보 복원
    for (int i = 0; i < edges.size(); i++) {
      this.edgePriorityQueue.enqueue(edges.get(i));
    }
  }

  private boolean isConnectedWith(Enum<?> fromVertex, Enum<?> toVertex) {
    boolean[] visited = new boolean[vertices.length];
    Stack<Enum<?>> vertexStack = new ListStack<>();
    vertexStack.push(fromVertex);

    while (!vertexStack.isEmpty()) {
      Enum<?> visitV = vertexStack.pop();
      if (visitVertex(visited, visitV)) {
        if (visitV.equals(toVertex)) {
          return true;
        }
      }

      List<Enum<?>> vertexList = vertices[visitV.ordinal()];
      for (int i = 0; i < vertexList.size(); i++) {
        Enum<?> vertex = vertexList.get(i);
        if (!visited[vertex.ordinal()]) {
          vertexStack.push(vertex);
        }
      }
    }

    return false;
  }

  private void recoverEdge(WeightEdge edge) {
    vertices[edge.fromVertex.ordinal()].insert(edge.toVertex);
    vertices[edge.toVertex.ordinal()].insert(edge.fromVertex);
  }

  private void removeEdge(Enum<?> fromVertex, Enum<?> toVertex) {
    removeVertexFromLink(fromVertex, toVertex);
    removeVertexFromLink(toVertex, fromVertex);
  }

  private void removeVertexFromLink(Enum<?> vertexA, Enum<?> vertexB) {
    List<Enum<?>> vertexLinkInfo = this.vertices[vertexA.ordinal()];
    for (int i = 0; i < vertexLinkInfo.size(); i++) {
      if (vertexLinkInfo.get(i).equals(vertexB)) {
        vertexLinkInfo.remove(i);
        return;
      }
    }
    throw new IllegalArgumentException("해당 정점들은 연결되어있지 않습니다.");
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

    private String showEdgeInfo() {
      return "(" + fromVertex.toString() + "-" + toVertex.toString() + "), " + "w: " + weight;
    }
  }
}
