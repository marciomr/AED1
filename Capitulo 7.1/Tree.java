import java.util.Iterator;

public interface Tree<E> {
  public int size();
  public boolean isEmpty();
//  public Iterator<E> iterator();
//  public Iterable<Position <E> > positions();
  public E replace(Position<E> p, E e) throws InvalidPositionException;
  public Position<E> root() throws EmptyTreeException;
  public Position<E> parent(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException;
  public Iterable<Position<E> > children(Position<E> p)
    throws InvalidPositionException;
  public boolean isInternal(Position<E> p) throws InvalidPositionException;
  public boolean isExternal(Position<E> p) throws InvalidPositionException;
  public boolean isRoot(Position<E> p) throws InvalidPositionException;
}
