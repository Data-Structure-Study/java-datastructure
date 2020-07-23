package list;

import java.util.Comparator;

public interface SortedList<E> extends List<E> {

  void setSortRule(Comparator<E> comp);
}
