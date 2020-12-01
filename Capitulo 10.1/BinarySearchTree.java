import java.util.Comparator;
import java.util.LinkedList;

public class BinarySearchTree<K,V>
  extends LinkedBinaryTree<Entry<K,V> > implements Dictionary<K,V> {
  protected Comparator<K> C;
  protected Position<Entry<K,V> > actionPos; //pai do nó a ser removido/inserido
  protected int numEntries;

  public BinarySearchTree(Comparator<K> c) {
    addRoot(null);
    C = c;
    numEntries = 0;
  }

  protected K key(Position<Entry<K,V> > position) {
    return position.element().getKey();
  }

  protected V value(Position<Entry<K,V> > position) {
    return position.element().getValue();
  }

  protected Entry<K,V> entry(Position<Entry<K,V> > position) {
    return position.element();
  }

  protected void replaceEntry(Position <Entry<K,V> > pos, Entry<K,V> ent) {
    ((BSTEntry <K,V>) ent).pos = pos;
    replace(pos,ent);
  }

  protected void checkKey(K key) throws InvalidKeyException {
    if(key == null) throw new InvalidKeyException("chave nula");
  }

  protected void checkEntry(Entry<K,V> ent) throws InvalidEntryException {
    if(ent == null || !(ent instanceof BSTEntry))
      throw new InvalidKeyException("entrada inválida");
  }

  protected Entry<K,V> insertAtExternal(Position<Entry<K,V> > v, Entry<K,V> e) {
    expandExternal(v, null, null);
    replace(v, e);
    numEntries++;

    return e;
  }

  protected void removeExternal(Position<Entry<K,V> > v) {
    removeAboveExternal(v);
    numEntries--;
  }

  protected Position<Entry<K,V> > treeSearch(K key, Position<Entry<K,V> > pos) {
    if(isExternal(pos)) return pos;
    else {
      K curKey = key(pos);
      int comp = C.compare(key, curKey);
      if(comp < 0) return treeSearch(key, left(pos));
      else if(comp > 0) return treeSearch(key, right(pos));
      return pos;
    }
  }

  protected void addAll(LinkedList<Entry<K,V> > L, Position<Entry<K,V> > v, K k) {
    if (isExternal(v)) return;
    Position<Entry<K, V> > pos = treeSearch(k,v);
    if(!isExternal(pos)) {
      addAll(L, left(pos), k);
      L.addLast(pos.element());
      addAll(L, right(pos), k);
    }
  }

  // aqui começam os métodos públicos

  public int size() { return numEntries; }

  public boolean isEmpty() { return size() == 0; }

  public Entry<K,V> find(K key) throws InvalidKeyException {
    checkKey(key);
    Position<Entry<K,V> > curPos = treeSearch(key, root());
    actionPos = curPos;
    if(isInternal(curPos)) return entry(curPos);
    return null;
  }

  public Iterable<Entry<K,V> > findAll(K key) throws InvalidKeyException {
    checkKey(key);
    LinkedList<Entry<K, V> > L = new LinkedList<Entry<K,V> >();
    addAll(L, root(), key);
    return L;
  }

  public Entry<K,V> insert(K k, V x) throws InvalidKeyException {
    checkKey(k);
    Position<Entry<K,V> > insPos = treeSearch(k, root());
    while(!isExternal(insPos))
      insPos = treeSearch(k, left(insPos));
    actionPos = insPos;
    return insertAtExternal(insPos, new BSTEntry<K,V>(k, x, insPos));
  }

  public Entry<K,V> remove(Entry<K,V> ent) throws InvalidEntryException {
    checkEntry(ent);
    Position<Entry<K,V> > rmPos = ((BSTEntry<K,V>)ent).position();
    Entry<K,V> toReturn = entry(rmPos);
    if(isExternal(left(rmPos))) rmPos = right(rmPos);
    else if(isExternal(right(rmPos))) rmPos = left(rmPos);
    else {
      Position<Entry<K,V> > swapPos = rmPos;
      rmPos = right(swapPos);
      do {
        rmPos = left(rmPos);
      } while (isInternal(rmPos));
      replaceEntry(swapPos, (Entry<K,V>) parent(rmPos).element());
    }
    actionPos = sibling(rmPos);
    removeExternal(rmPos);

    return toReturn;
  }

  protected static class IntComparator implements Comparator<Integer> {
      public int compare(Integer v1, Integer v2) {
        return Integer.compare(v1, v2);
      }
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree<Integer, String>(new IntComparator());
    bst.insert(1, "1");
    bst.insert(2, "2");
    bst.insert(3, "3");
    bst.insert(4, "4");
    System.out.println(bst.find(4).getValue());
  }

}
