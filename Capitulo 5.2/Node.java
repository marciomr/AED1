public class Node<E> {
  private E element;
  private Node next;

  public Node(E e, Node n){
    element = e;
    next = n;
  }

  public E getElement(){ return element; }
  public Node getNext(){ return next; }
  public void setElement(E newElement){ element = newElement; }
  public void setNext(Node newNext){ next = newNext; }
}
