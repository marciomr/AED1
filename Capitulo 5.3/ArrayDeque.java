class ArrayDeque<E> implements Deque<E> {
  protected int capacity;
  public static final int CAPACITY = 1000;
  protected E D[];
  protected int f, r;

  public ArrayDeque(){
    this(CAPACITY);
  }

  public ArrayDeque(int cap){
    capacity = cap;
    f = r = 0;
    D = (E[]) new Object[capacity];
  }

  public int size(){
    if(isEmpty()) return 0;
    return (capacity - f + r + 1) % capacity;
  }

  public boolean isEmpty(){ return D[f] == null; }

  public E getFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio");
    return D[f];
  }

  public E getLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio");
    return D[r];
  }

  public void addFirst(E element) throws FullDequeException {
    if(size() == capacity) throw new FullDequeException("A fila está cheia");
    if(!isEmpty()){
      f--;
      if (f < 0) f += capacity; // modulo em java não funciona com negativos
    }
    D[f] = element;
  }

  public void addLast(E element) throws FullDequeException {
    if(size() == capacity) throw new FullDequeException("A fila está cheia");
    if(!isEmpty()) r = (r + 1) % capacity;
    D[r] = element;
  }

  public E removeFirst() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio");
    E tmp = D[f];
    D[f] = null;
    f = (f + 1) % capacity;
    if(isEmpty()) f = r = 0;
    return tmp;
  }

  public E removeLast() throws EmptyDequeException {
    if(isEmpty()) throw new EmptyDequeException("Deque vazio");
    E tmp = D[r];
    D[r] = null;
    r--;
    if (r < 0) r += capacity;
    if(isEmpty()) f = r = 0;
    return tmp;
  }

  public String toString() {
    String s = "[";
    if(!isEmpty()){
     s += D[f];
     for(int i = 1, j = (f + 1) % capacity; i < size(); i++, j = (j + 1) % capacity)
      s += ", " + D[j];
    }
    return s + "]";
  }

  public static void main(String[] args) {
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
