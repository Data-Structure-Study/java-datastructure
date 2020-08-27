package table.chainedtable;

public class ChainedSlot<K, V> {

  private final K key;
  private final V value;

  public ChainedSlot(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public V getValue() {
    return this.value;
  }

  public K getKey() {
    return this.key;
  }
}
