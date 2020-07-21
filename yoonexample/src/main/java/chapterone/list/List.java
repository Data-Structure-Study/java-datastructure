package chapterone.list;

public interface List<E> {

  void insert(E data);

  int size();

  boolean isEmpty();

  boolean contians(Object o);

  E get(int index);

  E remove(int index);
}
