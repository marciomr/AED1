public class BTNode<E> implements BTPosition<E> {
  private E element;
  private BTPosition<E> left, right, parent;

  public BTNode(E e, BTPosition<E> l, BTPosition<E> r, BTPosition<E> p) {
    setElement(e);
    setLeft(l);
    setRight(r);
    setParent(p);
  }

  public E element() { return element; }

  public void setElement(E e) { element = e; }

  public BTPosition<E> getLeft() { return left; }

  public BTPosition<E> getRight() { return right; }

  public BTPosition<E> getParent() { return parent; }

  public void setLeft(BTPosition<E> l) { left = l; }

  public void setRight(BTPosition<E> r) { right = r; }

  public void setParent(BTPosition<E> p) { parent = p; }
}
