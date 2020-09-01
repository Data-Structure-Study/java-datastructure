package graph;

import java.util.StringJoiner;
import list.DummyDoublyLinkedList;
import list.List;
import queue.LinkedListQueue;
import queue.Queue;
import stack.ListStack;
import stack.Stack;

public class ListGraph implements Graph {

  private final List<Enum<?>>[] vertices;

  public ListGraph(int vertexCount, Class<? extends Enum<?>> clazz) {
    Enum<?>[] enumConstants = clazz.getEnumConstants();
    int min = Math.min(vertexCount, enumConstants.length);

    this.vertices = new List[min];
    for (int i = 0; i < min; i++) {
      this.vertices[i] = new DummyDoublyLinkedList<>();
      this.vertices[i].insert(enumConstants[i]);
    }
  }

  @Override
  public void addEdge(Enum<?> fromV, Enum<?> toV) {
    vertices[fromV.ordinal()].insert(toV);
    vertices[toV.ordinal()].insert(fromV);
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
}
