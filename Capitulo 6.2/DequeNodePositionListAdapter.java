public class DequeNodePositionListAdapter<E> implements Deque<E> {
  protected PositionList<E> list;

  public DequeNodePositionListAdapter(){
    list = new NodePositionList();
  }

  public int size(){ return list.size(); }

  public boolean isEmpty(){ return list.isEmpty(); }

  public E getFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return list.first().element();
  }

  public E getLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return list.last().element();
  }

  public void addFirst(E element){ list.addFirst(element); }

  public void addLast(E element){ list.addLast(element); }

  public E removeFirst() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return list.remove(list.first());
  }

  public E removeLast() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return list.remove(list.last());
  }

  public String toString() {
    String s = "[";

    if(!list.isEmpty()){
      for(Position<E> cur = list.first(); cur != list.last(); cur = list.next(cur))
        s += cur.element() + ", ";

      s += list.last().element();
    }

    return s + "]";
  }

  public static void main(String[] args) {
    Deque<Integer> A = new DequeNodePositionListAdapter<Integer>();
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
