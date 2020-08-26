package table;

public class SimpleTable<K, V> implements Table<K, V> {

  private final Object[] slots;
  private final HashFunction<K> hashFunction;

  public SimpleTable(HashFunction<K> hashFunction) {
    this(100, hashFunction);
  }

  public SimpleTable(int initialSize, HashFunction<K> hashFunction) {
    this.slots = new Object[initialSize];
    this.hashFunction = hashFunction;
  }

  @Override
  public void insert(K key, V value) {
    Slot<K, V> slot = new Slot<>();
    slot.insertData(key, value);

    int hash = hashFunction.hashFunction(key);
    this.slots[hash] = slot;
  }

  @Override
  public V search(K key) {
    Slot<K, V> slot = getSlotBy(key);

    if (slot.getStatus() != SlotStatus.INUSE) {
      return null;
    } else {
      return slot.getValue();
    }
  }

  @Override
  public V delete(K key) {
    Slot<K, V> slot = getSlotBy(key);

    if (slot.getStatus() != SlotStatus.INUSE) {
      return null;
    } else {
      return slot.deleteData();
    }
  }

  private Slot<K, V> getSlotBy(K key) {
    return (Slot<K, V>) this.slots[hashFunction.hashFunction(key)];
  }
}
