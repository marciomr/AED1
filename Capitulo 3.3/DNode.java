public class DNode{
  protected String element;
  protected DNode prev, next;

  public DNode(String e, DNode p, DNode n){
    element = e;
    prev = p;
    next = n;
  }

  public String getElement(){ return element; }
  public DNode getPrev(){ return prev; }
  public DNode getNext(){ return next; }

  public void setElement(String newElement){ element = newElement; }
  public void setPrev(DNode newPrev){ prev = newPrev; }
  public void setNext(DNode newNext){ next = newNext; }
}
