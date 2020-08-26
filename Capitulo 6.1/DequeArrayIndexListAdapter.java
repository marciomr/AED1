public class DequeArrayIndexListAdapter<E> implements Deque<E> {
  protected int capacity;
  public static final int CAPACITY = 1000;
  protected ArrayIndexList<E> V;

  public DequeArrayIndexListAdapter(){
    this(CAPACITY);
  }

  public DequeArrayIndexListAdapter(int cap){
    V = new ArrayIndexList(cap);
  }

  public int size(){ return V.size(); }

  public boolean isEmpty(){ return V.isEmpty(); }

  public E getFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return V.get(0);
  }

  public E getLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return V.get(size() - 1);
  }

  public void addFirst(E element){ V.add(0, element); }

  public void addLast(E element){ V.add(size(), element); }

  public E removeFirst() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return V.remove(0);
  }

  public E removeLast() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("Deque vazio.");
    return V.remove(size() - 1);
  }

  public String toString() {
    String s = "[";
    if(!isEmpty()) s += V.get(0);
    for(int i = 1; i < size(); i++)
      s += ", " + V.get(i);
    return s + "]";
  }

  public static void main(String[] args) {
    Deque<Integer> A = new DequeArrayIndexListAdapter<Integer>();
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
