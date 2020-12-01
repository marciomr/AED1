public class BSTEntry<K,V> implements Entry<K,V> {
  protected K key;
  protected V value;
  protected Position<Entry<K,V> > pos;

  BSTEntry(K k, V v, Position<Entry<K,V> > p) {
    key = k;
    value = v;
    pos = p;
  }

  public K getKey() { return key; }
  public V getValue() { return value; }
  public Position<Entry<K,V> > position() { return pos; }
}
