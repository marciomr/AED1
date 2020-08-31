import java.util.List;

public class TreeNode<E> implements Position<E> {
  protected E element;
  protected Position<E> parent;
  protected List<Position<E> > children;

  public TreeNode(E e, Position<E> p, List<Position <E> > c){
    element = e;
    parent = p;
    children = c;
  }

  public E element(){ return element; }
  public Position<E> getParent(){ return parent; }
  public List<Position<E> > getChildren(){ return children; }

  public void setChildren(List<Position <E> > newChildren) {
    children = newChildren;
  }

  public void setElement(E newElement){ element = newElement; }
  public void setParent(Position<E> newParent){ parent = newParent; }
}
