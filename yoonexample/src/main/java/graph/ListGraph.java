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
  }

  @Override
  public String showGraphEdgeInfo() {
    return null;
  }
}
