package table;

@FunctionalInterface
public interface HashFunction<K> {

  int hashFunction(K key);
}
