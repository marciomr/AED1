public interface BTPosition<E> extends Position<E> {
  public void setElement(E e);
  public BTPosition<E> getLeft();
  public BTPosition<E> getRight();
  public BTPosition<E> getParent();
  public void setLeft(BTPosition<E> l);
  public void setRight(BTPosition<E> r);
  public void setParent(BTPosition<E> p);
}
