public interface IndexList<E> {
  public int size();
  public boolean isEmpty();
  public void add(int i, E e) throws IndexOutOfBoundsException;
  public E get(int i) throws IndexOutOfBoundsException;
  public E remove(int i) throws IndexOutOfBoundsException;
  public E set(int i, E e) throws IndexOutOfBoundsException;
}
