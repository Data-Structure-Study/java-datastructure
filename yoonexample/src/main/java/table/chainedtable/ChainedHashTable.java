package table.chainedtable;

import list.DummyLinkedList;
import list.List;
import table.HashFunction;
import table.Table;

public class ChainedHashTable<K, V> implements Table<K, V> {

  private final List<ChainedSlot<K, V>>[] slots;
  private final HashFunction<K> hashFunction;

  public ChainedHashTable(HashFunction<K> hashFunction) {
    this(100, hashFunction);
  }

  public ChainedHashTable(int slotSize, HashFunction<K> hashFunction) {
    this.slots = new List[slotSize];
    this.hashFunction = hashFunction;
  }

  @Override
  public void insert(K key, V value) {
    if (search(key) != null) {
      System.out.println("키 중복");
      return;
    }

    List<ChainedSlot<K, V>> slotList = this.slots[hashFunction.hashFunction(key)];
    ChainedSlot<K, V> slot = new ChainedSlot<>(key, value);
    if (slotList == null) {
      this.slots[hashFunction.hashFunction(key)] = new DummyLinkedList<>();
      slotList = this.slots[hashFunction.hashFunction(key)];
    }
    slotList.insert(slot);
  }

  @Override
  public V search(K key) {
    List<ChainedSlot<K, V>> slotList = this.slots[hashFunction.hashFunction(key)];
    if (slotList == null || slotList.isEmpty()) {
      return null;
    }

    for (int i = 0; i < slotList.size(); i++) {
      ChainedSlot<K, V> slot = slotList.get(i);
      if (key.equals(slot.getKey())) {
        return slot.getValue();
      }
    }
    return null;
  }

  @Override
  public V delete(K key) {
    List<ChainedSlot<K, V>> slotList = this.slots[hashFunction.hashFunction(key)];
    if (slotList == null || slotList.isEmpty()) {
      return null;
    }

    for (int i = 0; i < slotList.size(); i++) {
      if (key.equals(slotList.get(i).getKey())) {
        return slotList.remove(i).getValue();
      }
    }
    return null;
  }
}
