public interface Dictionary<K,V> {
  // a quantidade de entradas
  int size();

  // verifica se o dicionário está vazio
  boolean isEmpty();

  // devolve uma entrada cuja chave é key
  Entry<K,V> find(K key);

  // devolve um iterator pra lista das entradas cuja chave é key
  Iterable<Entry<K,V> > findAll(K key);

  // insere um par chave/valor
  Entry<K,V> insert(K key, V value);

  // remove a entrada
  Entry<K,V> remove(Entry<K,V> e);
}
