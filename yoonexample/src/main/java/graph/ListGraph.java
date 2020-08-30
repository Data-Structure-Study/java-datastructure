package graph;

import list.DummyDoublyLinkedList;
import list.List;

public class ListGraph implements Graph {

  private final List<Enum<?>>[] vertexes;

  public ListGraph(int vertexCount, Class<? extends Enum<?>> clazz) {
    Enum<?>[] enumConstants = clazz.getEnumConstants();
    int min = Math.min(vertexCount, enumConstants.length);

    this.vertexes = new List[min];
    for (int i = 0; i < min; i++) {
      this.vertexes[i] = new DummyDoublyLinkedList<>();
      this.vertexes[i].insert(enumConstants[i]);
    }
  }

  @Override
  public void addEdge(Enum<?> fromV, Enum<?> toV) {
    vertexes[fromV.ordinal()].insert(toV);
    vertexes[toV.ordinal()].insert(fromV);
  }

  @Override
  public String showGraphEdgeInfo() {
    StringBuilder sb = new StringBuilder();

    for (List<Enum<?>> vertex : vertexes) {
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
