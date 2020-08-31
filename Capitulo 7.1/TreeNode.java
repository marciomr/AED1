public class TreeNode<E> implements Position<E> {
  protected E element;
  protected Position<E> parent;
  protected PositionList<Position<E> > children;

  public TreeNode(E e, Position<E> p, PositionList<Position <E> > c){
    element = e;
    parent = p;
    children = c;
  }

  public E element(){ return element; }
  public Position<E> getParent(){ return parent; }
  public PositionList<Position<E> > getChildren(){ return children; }

  public void setChildren(PositionList<Position <E> > newChildren) {
    children = newChildren;
  }
  
  public void setElement(E newElement){ element = newElement; }
  public void setParent(Position<E> newParent){ parent = newParent; }
}
