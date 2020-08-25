public class NodeDeque<E> implements Deque<E> {
  protected DNode<E> header, trailer;
  protected int size;

  public NodeDeque(){
    header = new DNode(null, null, null);
    trailer = new DNode(null, header, null);
    header.setNext(trailer);
    size = 0;
  }

  public int size(){ return size; }

  public boolean isEmpty(){ return size == 0; }

  public E getFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return (E) header.getNext().getElement();
  }

  public E getLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return (E) trailer.getPrev().getElement();
  }

  public void addFirst(E newElement) throws EmptyDequeException {
    DNode<E> second = header.getNext();
    DNode<E> first = new DNode(newElement, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }

  public void addLast(E newElement) throws EmptyDequeException {
    DNode<E> secondToLast = header.getPrev();
    DNode<E> last = new DNode(newElement, secondToLast, trailer);
    trailer.setPrev(last);
    secondToLast.setNext(last);
    size++;
  }

  public E removeFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    DNode<E> first = header.getNext();
    E tmp = first.getElement();
    DNode<E> second= first.getNext();
    header.setNext(second);
    second.setPrev(header);
    size--;
    return tmp;
  }

  public E removeLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    DNode<E> last = trailer.getPrev();
    E tmp = last.getElement();
    DNode<E> secondToLast= last.getPrev();
    trailer.setPrev(secondToLast);
    secondToLast.setNext(trailer);
    size--;
    return tmp;
  }

  public String toString(){
    String s = "[";
    DNode first = header.getNext();
    if(!isEmpty()) s += first.getElement();
    for(DNode cur = first.getNext(); cur != null ; cur = cur.getNext())
      s += ", " + cur.getElement();
    return s + "]";
  }

  public static void main(String[] args) {
    Object o;
    Deque<Integer> A = new ArrayDeque<Integer>();
    A.addFirst(7);
    A.addFirst(9);
    A.addFirst(42);
    System.out.println(A.size());
    System.out.println(A);
    A.addLast(12);
    System.out.println(A.size());
    System.out.println(A);
    A.removeLast();
    A.removeLast();
    System.out.println(A.size());
    System.out.println(A);
    A.removeFirst();
    System.out.println(A.size());
    System.out.println(A);
    A.removeFirst();
    System.out.println(A.size());
    System.out.println(A);
    A.addLast(7);
    A.addLast(9);
    A.addLast(42);
    System.out.println(A.size());
    System.out.println(A);
  }
}
