package graph;

import list.DummyDoublyLinkedList;
import list.List;

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
}
