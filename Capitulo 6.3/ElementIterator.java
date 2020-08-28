import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
  protected PositionList<E> list;
  protected Position<E> cursor;

  public ElementIterator(PositionList<E> L){
    list = L;
    cursor = (list.isEmpty()) ? null : list.first();
  }

  public boolean hasNext(){ return cursor != null; }

  public E next() throws NoSuchElementException {
    if(cursor == null)
      throw new NoSuchElementException("Não há próximo elemento.");
    E result = cursor.element();
    cursor = (cursor == list.last()) ? null : list.next(cursor);
    return result;
  }
}
