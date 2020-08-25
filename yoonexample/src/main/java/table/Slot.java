package table;

import static table.SlotStatus.DELETED;
import static table.SlotStatus.EMPTY;
import static table.SlotStatus.INUSE;

public class Slot<K, V> {

  private K key;
  private V value;
  private SlotStatus status;

  public Slot() {
    this.status = EMPTY;
  }

  public void insertData(K key, V value) {
    this.key = key;
    this.value = value;
    this.status = INUSE;
  }

  public V deleteData(V value) {
    V returnValue = this.value;
    this.key = null;
    this.value = null;
    this.status = DELETED;
    return returnValue;
  }

  public V getValue() {
    return this.value;
  }

  public K getKey() {
    return this.key;
  }

  public SlotStatus getStatus() {
    return status;
  }
}
