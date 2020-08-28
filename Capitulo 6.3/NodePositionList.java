import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E> {
  protected int numElements;
  protected DNode<E> header, trailer;

  public NodePositionList(){
    numElements = 0;
    header = new DNode<E>(null, null, null);
    trailer = new DNode<E>(null, header, null);
    header.setNext(trailer);
  }

  protected DNode<E> checkPosition(Position<E> p)
    throws InvalidPositionException {

    if(p == null)
      throw new InvalidPositionException("Posição nula.");
    if(p == header)
      throw new InvalidPositionException("O cabeçalho não é uma posição válido.");
    if(p == trailer)
      throw new InvalidPositionException("O rodapé não é uma posição válida.");

    try{
      DNode<E> tmp = (DNode<E>) p;
      if((tmp.getPrev() == null) || (tmp.getNext() == null))
        throw new InvalidPositionException("A posição não pertence a uma lista válida.");
      return tmp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException("A posição tem tipo diferente da lista.");
    }
  }

  public int size(){ return numElements; }

  public boolean isEmpty(){ return numElements == 0; }

  public Position<E> first() throws EmptyListException {
    if(isEmpty()) throw new EmptyListException("Lista vazia.");
    return header.getNext();
  }
  public Position<E> last() throws EmptyListException {
    if(isEmpty()) throw new EmptyListException("Lista vazia.");
    return trailer.getPrev();
  }

  public Position<E> next(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException{
    DNode<E> tmp = checkPosition(p);
    DNode<E> next = tmp.getNext();
    if(next == trailer)
      throw new BoundaryViolationException("Atingiu o final da lista.");
    return next;
  }

  public Position<E> prev(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    DNode<E> tmp = checkPosition(p);
    DNode<E> prev = tmp.getPrev();
    if(prev == header)
      throw new BoundaryViolationException("Atingiu o começo da lista.");
    return prev;
  }

  public void addFirst(E e) {
    numElements++;
    DNode<E> newNode = new DNode<E>(e, header, header.getNext());
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
  }

  public void addLast(E e) {
    numElements++;
    DNode<E> newNode = new DNode<E>(e, trailer.getPrev(), trailer);
    trailer.getPrev().setNext(newNode);
    trailer.setPrev(newNode);
  }

  public void addAfter(Position<E> p, E e) throws InvalidPositionException {
    DNode<E> tmp = checkPosition(p);
    numElements++;
    DNode<E> newNode = new DNode<E>(e, tmp, tmp.getNext());
    tmp.getNext().setPrev(newNode);
    tmp.setNext(newNode);
  }

  public void addBefore(Position<E> p, E e) throws InvalidPositionException {
    DNode<E> tmp = checkPosition(p);
    numElements++;
    DNode<E> newNode = new DNode<E>(e, tmp.getPrev(), tmp);
    tmp.getPrev().setNext(newNode);
    tmp.setPrev(newNode);
  }

  public E remove(Position<E> p) throws InvalidPositionException {
    DNode<E> tmp = checkPosition(p);
    numElements--;
    DNode<E> next = tmp.getNext();
    DNode<E> prev = tmp.getPrev();
    prev.setNext(next);
    next.setPrev(prev);
    E e = tmp.element();
    tmp.setNext(null);
    tmp.setPrev(null);

    return e;
  }

  public E set(Position<E> p, E e) throws InvalidPositionException {
    DNode<E> tmp = checkPosition(p);
    E oldElement = tmp.element();
    tmp.setElement(e);

    return oldElement;
  }

  public Iterator<E> iterator(){ return new ElementIterator<E>(this); }

  public Iterable<Position <E> > positions() {
    PositionList<Position<E> > P = new NodePositionList<Position<E> >();
    if(!isEmpty()){
      for(Position<E> p = first(); p != last(); p = next(p))
        P.addLast(p);
      P.addLast(last());
    }
    return P;
  }

  public String toString() {
    String s = "[";
    Iterator<E> it = iterator();

    while(it.hasNext()){
      s += it.next();
      if(it.hasNext()) s += ", ";
    }

    return s + "]";
  }

  public static void main(String[] args) {
    NodePositionList<Integer> list = new NodePositionList<Integer>();
    list.addFirst(2);
    list.addFirst(1);
    list.addLast(3);
    System.out.println(list);
    Position<Integer> segundo = list.next(list.first());
    list.remove(segundo);
    System.out.println(list);
    list.addAfter(list.first(), 2);
    System.out.println(list);
  }

}
