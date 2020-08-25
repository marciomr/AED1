public class DNode<E>{
  protected E element;
  protected DNode prev, next;

  public DNode(E e, DNode p, DNode n){
    element = e;
    prev = p;
    next = n;
  }

  public E getElement(){ return element; }
  public DNode getPrev(){ return prev; }
  public DNode getNext(){ return next; }

  public void setElement(E newElement){ element = newElement; }
  public void setPrev(DNode newPrev){ prev = newPrev; }
  public void setNext(DNode newNext){ next = newNext; }
}
